package string;

public class SpreadSheetEncodingDecoding {
    public static void main(String[] args){
        SpreadSheetEncodingDecoding obj = new SpreadSheetEncodingDecoding();
        System.out.println(obj.ssDecodeColId("ALM"));
        System.out.println(obj.ssEncodeColId(1001));

    }

    public int ssDecodeColId(String col){
        return col.chars().reduce(0,(result,c) -> result * 26 + c - 'A' +  1);
    }

    public String ssEncodeColId(int x){
        StringBuilder sb = new StringBuilder();
        while(x > 0){
            int index = (x-1) % 26;
            sb.append((char)(index + 'A'));
            x= (x-1)/26;
        }
        return sb.reverse().toString();
    }
}
