// Have one bug: the input to appendAbbeviation() could be empty. Check boundary for util functions..

public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> output = new ArrayList<>();
        output.add("");
        for (int i=0; i<word.length(); ++i) {
            char c = word.charAt(i);
            List<String> tmp = new ArrayList<>();
            for (String pre : output) {
                tmp.add(pre + String.valueOf(c));
                tmp.add(appendAbbeviation(pre));
            }
            output = tmp;
        }
        return output;
    }
    
    private String appendAbbeviation(String s) {
        // Had a bug: s could be "".
        if (s.isEmpty()) {
            return "1";
        }
        char last = s.charAt(s.length()-1);
        if (last >='0' && last <='9') {
            int v = (int)(last - '0') + 1;
            return s.substring(0, s.length()-1) + String.valueOf(v);
        } else {
            return (new StringBuilder(s)).append('1').toString();
        }
    }
}
