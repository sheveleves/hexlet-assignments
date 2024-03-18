package exercise;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String pathSourceFile1,
                                                       String pathSourceFile2,
                                                       String pathResultFile) {

        CompletableFuture<String> contentFile1 = CompletableFuture.supplyAsync(() -> {
            Path path1 = Paths.get(pathSourceFile1).toAbsolutePath().normalize();
            String content1 = null;
            try {
                content1 = Files.readString(path1);
            } catch (IOException e) {
                throw new RuntimeException("NoSuchFileException");
            }
            return content1;
        });

        CompletableFuture<String> contentFile2 = CompletableFuture.supplyAsync(() -> {

            Path path1 = Paths.get(pathSourceFile2).toAbsolutePath().normalize();
            String content2 = null;
            try {
                content2 = Files.readString(path1);
            } catch (IOException e) {
                throw new RuntimeException("NoSuchFileException");
            }
            return content2;
        });

        CompletableFuture<String> totalContent = contentFile1.thenCombine(contentFile2, (str1, str2) -> {
            Path sourcePath = Paths.get(pathResultFile).toAbsolutePath().normalize();
            String content = str1 + str2;
            try {
                Files.write(sourcePath,
                        content.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.WRITE);
            } catch (IOException e) {
                System.err.println("Failed to write the file" + e.getMessage());
            }
            return content;
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return null;
        });
        return totalContent;
    }

    public static CompletableFuture<Long> getFileSize(Path path) {
        return CompletableFuture.supplyAsync(() -> {
            long size;
            try {
                size = Files.size(path);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
            return size;
        });
    }

    public static Long getDirectorySize(String path) throws IOException, ExecutionException, InterruptedException {
        Path pathDir = Paths.get(path).toAbsolutePath().normalize();

        List<CompletableFuture<Long>> arrFutureSize = Files.list(pathDir).filter(Files::isRegularFile)
                .map(App::getFileSize)
                .toList();


        return CompletableFuture.allOf(arrFutureSize.toArray(new CompletableFuture[arrFutureSize.size()]))
                .thenApply(v -> arrFutureSize.stream()
                        .map(longCompletableFuture -> longCompletableFuture.join())
                        .reduce((l1, l2) -> l1 + l2)
                        .get()).get();
    }




    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        App.unionFiles("src/test/resources/file1.txt",
                "src/test/resources/file2.txt",
                "src/test/resources/total.txt").get();


        Long directorySize = getDirectorySize("src/test/resources/dir");
        System.out.println(directorySize);
        // END

    }
}

