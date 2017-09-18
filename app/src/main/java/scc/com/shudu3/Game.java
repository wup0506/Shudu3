package scc.com.shudu3;

/**
 * Created by wupingzyy on 2017/9/17.
 */

public class Game {
    private final String str= "360000000004230800000004200"
            +"070460003820000014500013020"
            +"001900000007048300000000045";
    private int shuduku []=new int[9*9];

    public Game(){
        shuduku=fromPuzzleString(str);
    }

    private int getTile(int x,int y){
        return shuduku[y*9+x];
    }

    public String getTitleString(int x,int y){
        int v=getTile(x,y);
        if (v==0){
            return "";
        }
        else
            return String.valueOf(v);
    }
    protected int[] fromPuzzleString(String src){
        int[] sudo=new int[src.length()];
        for (int i=0;i<sudo.length;i++){
            sudo[i]=src.charAt(i) -'0';
        }
        return sudo;
    }
}
