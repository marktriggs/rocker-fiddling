package net.dishevelled;

import java.util.*;

import com.fizzed.rocker.runtime.ArrayOfByteArraysOutput;

public class App
{
    public record FileEntry(String filename, int size, String mimeType) {}

    public static class H {
        public static String stuff() {
            return "<b>BOLD</b>";
        }

        public record ValueLabel<V>(V value, String label) {}
    }

    public static void main(String[] args) {
        try {
            ArrayOfByteArraysOutput output = views.index.template(
                                                                  "Mark",
                                                                  new Date(),
                                                                  Arrays.asList(
                                                                                new FileEntry("/etc/passwd", 3100, "text/plain"),
                                                                                new FileEntry("/etc/shadow", 6100, "text/plain"),
                                                                                new FileEntry("/dev/zero", 0, "application/octet-stream")
                                                                                ),
                                                                  "sort_a"
                                                                  )
                .render(ArrayOfByteArraysOutput.FACTORY);

            for (byte[] a : output.getArrays()) {
                System.out.write(a);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
