/**
 * 
 */
package com.china.gavin.game.qq;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
 

import com.sun.awt.AWTUtilities;

/**
 * @author gauzhang
 * 
 */
public class AdaLoginFrame2 extends JFrame {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 5229888443669758094L;
	
	private String bgtopc = ImageManager.getImageURL("logintc.png");
	private Image topl = ImageManager.getImageWithImgName("logintl.png");
	private Image topr = ImageManager.getImageWithImgName("logintr.png");
	private TexturePaint topcPaint = ImageManager.createTexturePaint(bgtopc);

	private Image bgline = ImageManager.getImageWithImgName("loginline.png");
	private TexturePaint bglinePaint = ImageManager.createTexturePaint(bgline);

	private String bgbottomc = ImageManager.getImageURL("loginbc.png");
	private Image bottoml = ImageManager.getImageWithImgName("loginbl.png");
	private Image bottomr = ImageManager.getImageWithImgName("loginbr.png");
	private TexturePaint bottomcPaint = ImageManager.createTexturePaint(bgbottomc);

	private Image miniImgTwo = ImageManager.getImageWithImgName("miniturn.png");
	private ImageIcon minButtonIcon = ImageManager.getIconWithName("transmini.png");
	private ImageIcon minButtonRoverIcon = createIcon(miniImgTwo, 0, 0, 18, 22);
	private ImageIcon minButtonPressedIcon = createIcon(miniImgTwo, 18, 0, 26, 22);

	private Image closeImgTwo = ImageManager.getImageWithImgName("dialog_close.png");
	private ImageIcon closeButtonIcon = ImageManager.getIconWithName("transclose.png");
	private ImageIcon closeButtonRoverIcon = createIcon(closeImgTwo, 0, 0, 35, 22);
	private ImageIcon closeButtonPressedIcon = createIcon(closeImgTwo, 36, 0, 35, 22);
	private JButton splitButton = createCommonButton(ImageManager.getIconWithName("loginsplit.png"));

	private Image banner = ImageManager.getImageWithImgName("loginbanner.png");
	private Image logginProcessback = ImageManager.getImageWithImgName("login_processbar2.png");
	private Image logginProcess = ImageManager.getImageWithImgName("loginprocess.png");

	private JButton minButton = ImageManager.createTransparentButton(minButtonIcon, minButtonRoverIcon,
			minButtonPressedIcon);
	private JButton closeButton = ImageManager.createTransparentButton(closeButtonIcon, closeButtonRoverIcon,
			closeButtonPressedIcon);
	
	private ImageIcon logoIcon = ImageManager.getIconWithName("qqlogo.png");
	
	private ImageIcon advset = ImageManager.getIconWithName("setbutton.png");
	private JButton setButton = createCommonButton(advset);
	
	private ImageIcon loginButtonIcon = ImageManager.getIconWithName("login.png");	
	private ImageIcon loginButtonRoverIcon = ImageManager.getIconWithName("loginh.png");
	private JButton loginButton = ImageManager.createTransparentButton(loginButtonIcon, loginButtonRoverIcon,
			loginButtonRoverIcon);
	
	private ImageIcon ckButtonIcon = ImageManager.getIconWithName("emptyck.png");
	private JButton ckButton = createCommonButton(ckButtonIcon);
	
	private JLabel hintText = new JLabel("请输入帐号和密码：");
	private JLabel userIDText = new JLabel("账号：");
	private JLabel pwdText = new JLabel("密码：");
	private JLabel remText = new JLabel("记着我哈");
	
	//id border color: 82 186 255
	//pwd 107 174 222
	
	private Color idBordercolor = new Color(82,186,255);
	private Color pwdBordercolor = new Color(107,174,222);
	
	
	
	private Font commonTxtFont = new Font("宋体", Font.PLAIN, 12);

	private int width = 354;
	//private int height = 240;
	// 354

	private final int topheight = topl.getHeight(null);

	private JPanel topPanel = new JPanel() {
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;

			g2d.drawImage(topl, 0, 0, null);
			g2d.setPaint(topcPaint);
			g2d.drawImage(topl, 0, 0, null);
			int x = topl.getWidth(null);
			int y = 0;
			g2d.fillRect(x, y, 334, 29);
			g2d.drawImage(topr, 344, 0, null);

		}
	};

	private JPanel bottomPanel = new JPanel() {
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;

			g2d.drawImage(bottoml, 0, 0, null);
			g2d.setPaint(bottomcPaint);
			g2d.drawImage(bottoml, 0, 0, null);
			int x = bottoml.getWidth(null);
			int y = 0;
			g2d.fillRect(x, y, 334, 39);
			g2d.drawImage(bottomr, 344, 0, null);

		}
	};

	private JPanel llinePanel = new JPanel() {

		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2d = (Graphics2D) g;
			g2d.setPaint(bglinePaint);
			g2d.fillRect(0, 0, 1, 175);

		}
	};

	private JPanel rlinePanel = new JPanel() {

		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2d = (Graphics2D) g;
			g2d.setPaint(bglinePaint);
			g2d.fillRect(0, 0, 1, 175);

		}
	};

	private JButton createCommonButton(ImageIcon icon) {
		JButton button = new JButton();
		button.setBounds(110, 20, 40, 20);
		button.setBorder(null);
		button.setMargin(null);
		button.setOpaque(false);
		button.setIcon(icon);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setRequestFocusEnabled(false);

		return button;
	}

	public AdaLoginFrame2() {
		setIconImage(ImageManager.getImageWithImgName("qqlogo.png"));
		init();
	}

	private void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		// this.setIconImage(traceImg);

		// opaque switch
		AWTUtilities.setWindowOpaque(this, true);
		JPanel contentPanel = new JPanel();
		//contentPanel.setOpaque(false);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(null);
		contentPanel.addMouseListener(moveWindowListener);
		contentPanel.addMouseMotionListener(moveWindowListener);
		
		// 0075ad
		topPanel.setBounds(0, 0, 354, topheight);
		//topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		topPanel.setLayout(null);

		//createCommonButton(logoIcon)
		JButton logoButton = createCommonButton(logoIcon);
		logoButton.setBounds(8, 5, 16, 16);
		JLabel logoText = new JLabel("QQ游戏2010");
		Font logoFont = new Font("宋体", Font.BOLD, 13);
		logoText.setForeground(Color.BLACK);
		logoText.setBounds(28, 3, 150, 20);
		logoText.setFont(logoFont);
		topPanel.add(logoText);
		
		topPanel.add(logoButton);
		minButton.setBounds(301, 0, 18, 22);
		topPanel.add(minButton);
		splitButton.setBounds(320, 0, 2, 22);
		topPanel.add(splitButton);
		
		closeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closeButton.setBounds(324, 0, 35, 22);
		closeButton.setToolTipText("Close");
		
		minButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AdaLoginFrame2.this.setExtendedState(JFrame.ICONIFIED);
			}
		});
		
		topPanel.add(closeButton);
		

		contentPanel.add(topPanel);

		llinePanel.setBounds(0, topheight, 1, 175);
		contentPanel.add(llinePanel);
		
		ImagePanel bannerPanel= new ImagePanel(banner, 0, 0);
		bannerPanel.setBounds(2, topheight, 350, 70);
		contentPanel.add(bannerPanel);

		ImagePanel processPanel= new ImagePanel(logginProcessback, 0, 0);
		processPanel.setBounds(2, topheight+70, 350, 4);		
		processPanel.setOpaque(false);
		//contentPanel.add(processPanel);
		
		ImagePanel processPanelDynamic= new ImagePanel(logginProcess, 0, 0);
		processPanelDynamic.setBounds(2, topheight+70, 39, 4);	
		//processPanelDynamic.setBorder(BorderFactory.createLineBorder(Color.RED));
		contentPanel.add(processPanelDynamic);
		contentPanel.add(processPanel);
		
		hintText.setBounds(15, topheight+74, 200, 18);
		hintText.setFont(commonTxtFont);
		contentPanel.add(hintText);
		
		userIDText.setBounds(15, topheight+96, 200, 18);
		userIDText.setFont(commonTxtFont);
		contentPanel.add(userIDText);
		
		JTextField userIDInput = new JTextField();
		userIDInput.setBorder(BorderFactory.createLineBorder(idBordercolor));
		userIDInput.setBounds(55, topheight+96, 230, 20);
		contentPanel.add(userIDInput);
		
		pwdText.setBounds(15, topheight+120, 200, 18);
		pwdText.setFont(commonTxtFont);
		contentPanel.add(pwdText);
		
		JPasswordField pwdInput = new JPasswordField();
		pwdInput.setBorder(BorderFactory.createLineBorder(pwdBordercolor));
		pwdInput.setBounds(55, topheight+122, 230, 20);
		contentPanel.add(pwdInput);
		
		ckButton.setBounds(55, topheight+151, 13, 13);
		contentPanel.add(ckButton);
		
		remText.setFont(commonTxtFont);
		remText.setBounds(73, topheight+149, 60, 18);
		contentPanel.add(remText);
		
		rlinePanel.setBounds(353, topheight, 1, 175);
		contentPanel.add(rlinePanel);

		// downPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		bottomPanel.setBounds(0, 204, 354, 39);
		contentPanel.add(bottomPanel);
		
		bottomPanel.setLayout(null);
		setButton.setBounds(10,10, 76,23);
		bottomPanel.add(setButton);
		loginButton.setBounds(260,10, 76,22);
		bottomPanel.add(loginButton);

		this.setContentPane(contentPanel);

		this.setSize(width, 243);
		centerWindow(this);

	}

	private void centerWindow(JFrame frame) {
		// location
		Dimension screSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = screSize.width;
		int y = screSize.height;
		int appW = (int) getSize().getWidth();
		int appH = (int) getSize().getHeight();
		// display center
		frame.setLocation((x - appW) / 2, (y - appH) / 2);

	}

	private ImageIcon createIcon(Image image, int startx, int starty, int width, int height) {
		CropImage ci = new CropImage(image, startx, starty, width, height);
		return new ImageIcon(ci.getImage());
	}
	
	private MouseAdapter moveWindowListener = new MouseAdapter() {

		private Point lastPoint = null;

		@Override
		public void mousePressed(MouseEvent e) {
			lastPoint = e.getLocationOnScreen();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			Point point = e.getLocationOnScreen();
			int offsetX = point.x - lastPoint.x;
			int offsetY = point.y - lastPoint.y;
			Rectangle bounds = AdaLoginFrame2.this.getBounds();
			bounds.x += offsetX;
			bounds.y += offsetY;
			AdaLoginFrame2.this.setBounds(bounds);
			lastPoint = point;
		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				//ImageManager.setupLookAndFeel();
				AdaLoginFrame2 ui = new AdaLoginFrame2();

				ui.setVisible(true);
			}
		});

	}
}

class ImagePanel extends JPanel {
	/**
	 * 
	 */
	private int x = 0;
	private int y = 0;
	private Image image;
	private static final long serialVersionUID = 1L;

	public ImagePanel(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(image, x, y, null);
	}
}
