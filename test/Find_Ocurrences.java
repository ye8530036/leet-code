import java.util.ArrayList;
import java.util.List;

class Find_Ocurrences {
    public String[] findOcurrences(String text, String first, String second) {
        String[] sb = text.split(" ");
        List<String> list = new ArrayList<>();
        int n = sb.length;
        for (int i=0 ;i+2<n;i++){
            if (sb[i].equals(first) && sb[i+1].equals(second)){
                list.add(sb[i+2]);
            }
        }
        return list.toArray(new String[0]);
    }
}
