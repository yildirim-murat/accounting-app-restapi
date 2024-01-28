package gov.toki.accountingapprestapi.core.domain.helper;

@Component
@RequiredArgsConstructor
public class SecurityHelper {

    private final AuthorityNameMapper authorityNameMapper;

    public boolean isLoggedInUser(String username) {
        return SecurityStaticHelper.getUsername().map(currUsername -> currUsername.equals(username)).orElse(false);
    }

    public boolean isLoggedInUser(List<String> usernames) {
        if (usernames == null || usernames.isEmpty() || new HashSet<>(usernames).size() > 1) return false;
        return isLoggedInUser(usernames.get(0));
    }

    public Optional<String> getCurrentUsername() {
        return SecurityStaticHelper.getUsername();
    }

    public List<String> getAuthorities() {
        return SecurityStaticHelper.getAuthorities();
    }

}
