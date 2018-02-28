import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;

import java.io.File;

public class Autoix {
    public static void main(String[] args) {

        File file = new File("C:\\idea_demo\\jacob\\lib","jacob-1.18-x64.dll");
        System.setProperty(LibraryLoader.JACOB_DLL_PATH,file.getAbsolutePath());
        AutoItX x = new AutoItX();
        String notepad = "无标题 - 记事本";
        String testString = "this is a test.";
//运行notepad.exe
        x.run("notepad.exe","",AutoItX.SW_SHOW);
//验证程序成功打开
        x.winActivate(notepad);
        x.winWaitActive(notepad);
//输入test内容
        x.send(testString);
//Assert.assertTrue(x.winExists(notepad, testString));
//点击关闭按钮
        x.winClose(notepad, testString);
//激活记事本窗口
        x.winWaitActive("记事本");
        x.send("{ALT}n");
//Assert.assertFalse(x.winExists(notepad, testString));
    }
}
