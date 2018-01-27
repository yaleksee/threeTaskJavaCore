package QuestionThree;

import java.util.ArrayList;

public class CoverText {

    public static String wrapText(String text, int maxCharsPerLine) {
        if (maxCharsPerLine <= 0) throw new IllegalArgumentException("maxCharsPerLine > 0");
        String interval = " ";
        String transferal = "\n";
        String[] set = text.split(transferal);
        StringBuilder res = new StringBuilder();
        int currentLen = 0;

        for (String setence : set) {
            String[] words = setence.split(interval);
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.length() == 0) continue;

                int potent = currentLen == 0 ? word.length() : currentLen + 1 + word.length();
                if (potent == maxCharsPerLine || potent + 1 == maxCharsPerLine) {
                    if (currentLen > 0) res.append(interval);
                    res.append(word);
                    res.append(transferal);
                    currentLen = 0;
                } else if (potent + 1 < maxCharsPerLine) {
                    if (currentLen > 0) res.append(interval);
                    res.append(word);
                    currentLen = potent;
                } else {
                    if (word.length() <= maxCharsPerLine) {
                        res.append(transferal);
                        currentLen = 0;
                        i--;
                    } else {
                        if (currentLen > 0) {
                            res.append(interval);
                            currentLen++;
                        }
                        res.append(word.substring(0, maxCharsPerLine - currentLen));
                        res.append(transferal);
                        String restWord = word.substring(maxCharsPerLine - currentLen);
                        ArrayList<String> chuck = chunkText(restWord, maxCharsPerLine);
                        for (int j = 0; j < chuck.size(); j++) {
                            String currentChunk = chuck.get(j);
                            res.append(currentChunk);
                            if (j == chuck.size() - 1 && currentChunk.length() < maxCharsPerLine - 1) {
                                currentLen = currentChunk.length();
                            } else {
                                res.append(transferal);
                                currentLen = 0;
                            }
                        }
                    }
                }
            }
        }
        return res.toString();
    }

    private static ArrayList<String> chunkText(String word, int size) {
        ArrayList<String> chunkedWord = new ArrayList<String>();
        for (int i = 0; i < word.length(); i += size) {
            if (i + size > word.length()) chunkedWord.add(word.substring(i));
            else chunkedWord.add(word.substring(i, i + size));
        }
        return chunkedWord;
    }
}
