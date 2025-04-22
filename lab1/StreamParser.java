package Parser;

import java.io.*;


public class StreamParser {
    private final StringBuilder text = new StringBuilder();

    public StreamParser(String args) {
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(args));
            char[] buffer = new char[1024];
            int bytesRead;
            while ((bytesRead = reader.read(buffer)) != -1) {
                text.append(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }


    public String nextWord() {
        if (text.isEmpty()) return null;

        int i = 0;
        while (i < text.length() && !Character.isLetterOrDigit(text.charAt(i))) {
            i++;
        }

        if (i == text.length()) {
            return null;
        }

        int start = i;
        while (i < text.length() && Character.isLetterOrDigit(text.charAt(i))) {
            i++;
        }

        String word = text.substring(start, i);
        text.delete(0, i);
        return word;
    }
}
