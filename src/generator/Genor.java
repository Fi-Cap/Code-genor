package generator;

public class Genor {
    String Lang = "en";

    public void setLanguage(String lang) {
        Lang = lang;
    }

    public String[] genWindowCode(String[] args) {
        String[] codes = { "", "" };
        if (Lang != null || Lang == "en") {
            codes[0] = "//TODO Auto-generated method stub";
        }
        if (Lang != null || Lang == "zh-cn") {
            codes[0] = "//TODO 自动生成的方法存根";
        }
        codes[0] = codes[0] + "\nimport java.awt.*;\nimport java.awt.event.*;\nimport javax.swing.*;\nimport .*;";
        codes[0] = codes[0] + args[1] + " " + args[0] + "= new " + args[1] + ";";
        System.out.println(codes[0]);
        codes[1] = "package " + args[1];
        return (codes);
    }

    public String[] GetWindowArgs(String name, String classname, String title, int DefaultCloseOperation, boolean defaultLookAndFeelDecorated) {
        String[] r = new String[]{name, classname, title, IntToString(DefaultCloseOperation), BoolToString(defaultLookAndFeelDecorated)};
        return (r);
    }

    private String IntToString(int arg) {
        return (String.valueOf(arg));
    }

    private String BoolToString(boolean arg) {
        if (arg) {
            return ("true");
        } else {
            return ("false");
        }
    }

}