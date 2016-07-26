package com.china.gavin.demo;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CrawlWebPageInfo {
    private Frame f;
    private Button but;
    private TextField tfd;
    private TextArea tar;
    private Dialog d;
    private Label l;
    private Button okbut;
    public void init() {
        f = new Frame("dfa");
        f.setBounds(300, 100, 800, 600);
        f.setLayout(new FlowLayout());
        but = new Button("zhuandao");
        tfd = new TextField(80);
        tar = new TextArea(30, 90);
        d = new Dialog(f, "dsf", true);
        l = new Label();
        okbut = new Button("ok");
        d.add(l);
        d.add(okbut);
        d.setLayout(new FlowLayout());
        d.setBounds(400, 300, 200, 200);
        f.add(tfd);
        f.add(but);
        f.add(tar);
        f.setVisible(true);
        myEvent();
    }

    private void myEvent() {
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        d.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                d.setVisible(false);
            }

        });
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long s = System.currentTimeMillis();
                down2(tfd.getText());
                long s1 = System.currentTimeMillis();
                System.out.println("spend的时间" + (s - s1));
            }

        });
        okbut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
            }
        });
        tfd.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
            public void keyReleased(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    long s = System.currentTimeMillis();
                    down2(tfd.getText());
                    long s1 = System.currentTimeMillis();
                    System.out.println("spend的时间" + (s - s1));
                }

            }
        });

    }

    /*public void down() {
        tar.setText("");
        File f = new File("src/my/2.txt");
        List list = new ArrayList();
        try {
            URL url = new URL(tfd.getText());
            Reader in = new InputStreamReader(url.openStream());
            Writer out = new OutputStreamWriter(new FileOutputStream(f));
            int len = -1;
            char[] b = new char[1024];
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, b.length);
                String str = new String(b);
                // tar.append(str);
                int i = 0, j;
                String ss[] = str.split("\"");
                System.out.println("5336479.html".length());
                while (i < ss.length) {
                    if (ss[i].length() == 12 && ss[i].endsWith("html")) {
                        tar.append(ss[i] + "\r\n");
                        list.add(ss[i]);
                    }
                    i++;
                }
            }
            in.close();
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        l.setText("ni shu ru de  is error");
        d.setVisible(true);
        for(int index=0;index<list.size();index++)
        {
            String url_my="http://www.xs52.com/xiaoshuo/20/20221/"+list.get(index);
           down2(index,url_my);
        }

    }*/

    public void down2(String url_my) {
        tar.setText("~");
        tar.append(url_my + "\r\n");
        File f = new File("src/my/myTest.txt");
        List list = new ArrayList();
        try {
            URL url = new URL(url_my);
            Reader in = new InputStreamReader(url.openStream());
            Writer out = new OutputStreamWriter(new FileOutputStream(f));
            int len = -1, index = 1;
            char[] b = new char[1024];
            while ((len = in.read(b)) != -1) {
                // out.write(b, 0, b.length);
                int i = 0, j = 0;
                boolean flag = false;
                boolean flag1 = false;
                index++;
                while (i < b.length && index < 9 && index > 3) {

                    while (!flag && i < b.length) {

                        if (b[i] == '>') {
                            flag = true;
                            i++;
                            break;
                        }
                        i++;
                    }
                    while (flag && i < b.length) {
                        if (b[i] == '<') {
                            flag = false;
                            i++;
                            break;
                        }

                        if (i < 1019 && b[i] == '&' && b[i + 1] == 'n' && b[i + 2] == 'b' && b[i + 3] == 's'
                            && b[i + 4] == 'p' && b[i + 5] == ';') {
                            i = i + 5;
                        } else {
                            if (b[i] != '\r' && b[i] != '\n' && b[i] != ' ') {
                                out.write(b[i]);
                                tar.append(b[i] + "");
                            }
                        }

                        i++;
                    }
                    tar.append("\r\n");
                }
            }
            in.close();
            out.close();
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            l.setText("网络没连上，超时！");
        }
    }
    public static void main(String[] args) {
        new CrawlWebPageInfo().init();
    }
}