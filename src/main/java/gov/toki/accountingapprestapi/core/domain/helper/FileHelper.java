package gov.toki.accountingapprestapi.core.domain.helper;

@UtilityClass
public class FileHelper {

    @SneakyThrows(IOException.class)
    public Stream<Path> findAllMatchingFiles(Path start, String regex) {
        if (Files.notExists(start)) return Stream.empty();
        return Files.find(start, Integer.MAX_VALUE, (path, basicFileAttributes) -> path.toFile().getName().matches(regex));
    }

    public String getFileNameFromAbsolutePath(String absolutePath) {
        return StringUtils.substringAfterLast(absolutePath, '\\');
    }

    @SneakyThrows(FileNotFoundException.class)
    public InputStream getInputStreamFromPath(String path) {
        return new FileInputStream(path);
    }

}
