package sean.crackingTheCodingInterview.ch1ArraysAndStrings;

public interface SpaceReplacer {

  String replaceSpaces(String input);

  class StringBuilderSpaceReplacer implements SpaceReplacer {

    @Override
    public String replaceSpaces(String input) {
      if (input.isEmpty()) {
        return input;
      }
      StringBuilder sb = new StringBuilder((int) ((float) input.length() * 1.1));
      for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if (c == ' ') {
          sb.append("%20");
        } else {
          sb.append(c);
        }
      }
      return sb.toString();
    }
  }
}
