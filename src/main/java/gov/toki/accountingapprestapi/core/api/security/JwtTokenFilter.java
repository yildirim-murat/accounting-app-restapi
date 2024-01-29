package gov.toki.accountingapprestapi.core.api.security;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenHelper jwtTokenHelper;
    private final UserService userService;
    private final GrantedAuthorityMapper grantedAuthorityMapper;
    private static final RequestMatcher REQUEST_MATCHER;

    static {
        String[] antPatterns = SecurityConfig.getPublicEndPoints();
        List<RequestMatcher> matchers = new ArrayList<>(antPatterns.length);
        for (String pattern : antPatterns)
            matchers.add(new AntPathRequestMatcher(pattern, null));
        REQUEST_MATCHER = new OrRequestMatcher(matchers);
    }

    @Override
    protected boolean shouldNotFilter(@NonNull HttpServletRequest request) {
        return REQUEST_MATCHER.matches(request);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain chain) throws ServletException, IOException {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null) {
            chain.doFilter(request, response);
            return;
        }

        String token = header.substring(JwtTokenHelper.SCHEME.length() + 1);
        Claims claims = jwtTokenHelper.getClaims(token);
        jwtTokenHelper.valid(claims);
        String username = claims.getSubject();

        UserAuthProjection user = userService.getUserAuthProjection(username);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user, null, grantedAuthorityMapper.map(user.getRoles()));
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

}