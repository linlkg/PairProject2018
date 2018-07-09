import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //读入TXT文件
        Scanner input=new Scanner(System.in);
        String path = input.next();
        List<String> wordArray = new ArrayList<String>();
        int countChar=0;
        int countWord=0;
        int counLine=0;
        InputStreamReader reader = new InputStreamReader(new FileInputStream(path)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言

        List<String> lists = new ArrayList<String>();  //存储过滤后单词的列表
        String readLine = null;
        while((readLine = br.readLine()) != null){
            //System.out.println(readLine);
            countChar += readLine.length();//字符个数就是字符长度
            counLine++;//一行一行读，每读一行行数加1
            String[] wordsArr1 = readLine.split(" ");//以空格和非字母数字符号分割，至少4个英文字母开头，跟上字母数字符号
            for (String word : wordsArr1) {
                    lists.add(word);
            }
        }
        reader.close();//关闭文件
////        wordcount(lists);
    Map<String, Integer> wordsCount = new TreeMap<String,Integer>();  //存储单词计数信息，key值为单词，value为单词数

    //单词的词频统计
        for (String li : lists) {
        if(wordsCount.get(li) != null){
            wordsCount.put(li,wordsCount.get(li) + 1);
        }else{
            wordsCount.put(li,1);
        }
            countWord++;
    }
        System.out.println("characters:"+countChar);
        System.out.println("words:"+countWord);
        System.out.println("lines:"+counLine);
        SortMap(wordsCount);    //按值进行排序

}

    //按value的大小进行排序
    public static void SortMap(Map<String,Integer> oldmap){
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(oldmap.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();  //降序
            }
        });
        for(int i = 0; i<10; i++){//list.size() 只输出频率最高的10个
            System.out.println(list.get(i).getKey()+ ": " +list.get(i).getValue());
        }
    }


            //写入Txt文件
            /*File writename = new File(".\\test\\output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write("我会写入文件啦\r\n"); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件*/


    /*public static int wordcount(List<String> input){
        for (String word : input) {
            char[] ch=word.toCharArray();//ch每个单词
            for(char c:ch) {//c是单词中每个字符
            }
        }
        return  0;
    }*/
}

