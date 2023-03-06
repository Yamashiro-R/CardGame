import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Display implements ActionListener {

	// 画面全体のオブジェクト
	private JFrame disp;
	
	// パネルオブジェクト（上部／中央／下部）
	private JPanel top_panel, mid_panel, bottom_Panel;
	
	// メッセージ表示ラベルオブジェクト
	private JLabel msg_lbl;
	
	// 親のカード情報ラベルオブジェクト（マーク、数字）
	private JLabel parent_lbl;
	private JLabel parentHandSuitLbl[] = new JLabel[5];
	private JLabel parentHandNoLbl[] = new JLabel[5];
	
	
	// 子のカード情報ラベルオブジェクト（マーク、数字）
	private JLabel child_lbl, child_suit_lbl, child_no_lbl;
	
	// ボタンオブジェクト ()
	
	// プレイヤーオブジェクト（親、子）
	private Player parent, child;
	
	// コンストラクタ
	public Display( Player prn , Player chd) {
		
		parent = prn;
		child = chd;
		
		// ゲーム画面全体の表示
		disp = new JFrame("POKER GAME");		// 画面を生成
		disp.setSize(480,600);							// 画面サイズを設定
		disp.setLocationRelativeTo(null);			// 画面の表示位置を中央に設定
		disp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// 「✕」ボタンで画面を閉じるように設定
		disp.setResizable(false); 														// 画面サイズを変更できないように設定
		
		// トップパネルの表示設定
		top_panel = new JPanel();					// パネルを生成
		setPanel( top_panel, Color.ORANGE, null, new Dimension(480, 50) );		// パネルの背景色、レイアウト、サイズを設定
		disp.add( top_panel, BorderLayout.NORTH );			// 画面上部にパネルを追加
		
		// メッセージラベルを表示
		msg_lbl = new JLabel("ここに表示したいメッセージを入力！！！");		// ラベルを生成
		top_panel.add(msg_lbl);	// トップパネルに追加
		setLabelFont(msg_lbl, Color.BLACK,0, 15, 480, 20, 20, false);			// ラベルのフォント設定
		
		// ミドルパネルの表示設定
		mid_panel = new JPanel();				// パネルを生成
		//setPanel( mid_panel, Color.CYAN, null, new Dimension(480, 180) );			// パネルの背景色、レイアウト、サイズを設定
		// アイコンが回り込んでいる。
		disp.add(mid_panel, BorderLayout.CENTER);			// 画面中央部にパネルを追加
		
		
		
		// 親カードの情報を表示
		parent_lbl = new JLabel("私のカード");
		parentHandSuitLbl[0] = new JLabel( getSuitIcon( parent.GetSuit(0) ) );
		parentHandNoLbl[0] = new JLabel( getNoStr( parent.GetNo(0) ) );
		
		
		ImageIcon TestImage ;
		TestImage = new ImageIcon("./src/dog.jpg" ); //C:/pleiades/CardGame/src/dog.jpg(絶対パス or CardGameをカレントディレクトリとしてからの相対パス指定)
		JLabel Test = new JLabel( TestImage );
		System.out.println(Test);
		// ミドルパネルに追加
		mid_panel.add(parent_lbl);
		mid_panel.add(parentHandSuitLbl[0]);
//		mid_panel.add(Test);
//		mid_panel.add(parentHandNoLbl[0]);
		
		// ラベルのフォントを設定
		setLabelFont(parent_lbl,Color.WHITE,90,10,100,20,14,false);
		setLabelFont(parentHandSuitLbl[0],Color.WHITE,100,10,80,100,16,false);
		setLabelFont(parentHandNoLbl[0],Color.WHITE,100,35,80,100,16,true);
		
		// 子カード情報の表示
//		child_lbl = new Jlabel("あなたのカード");
		
		// ゲーム画面の表示
		disp.setVisible(true);
		
	}
	
	 //ボタンが押されたときのイベント
	 public void actionPerformed(ActionEvent e) {
		 String cmd = e.getActionCommand();
		 
}
	
	
	// パネルのフォント設定を行うメソッド
	public static void setPanel(JPanel panel, Color color, BorderLayout layout, Dimension dimension) {
		panel.setBackground(color);					// 背景色を設定
		panel.setLayout(layout);						// レイアウトを設定
		panel.setPreferredSize(dimension);		// 表示サイズを設定
	}
	
	// ラベルのフォント設定を行うメソッド
	public static void setLabelFont(JLabel label, Color clr, 
												int x_pos, int y_pos,
												int x_size, int y_size,
												int strSize, boolean opq)  {
		label.setBackground(clr);																		// 背景色を設定
		label.setLocation(x_pos, y_pos);															// 表示位置を設定
		label.setSize(x_size, y_size);																	// 表示サイズを設定
		label.setFont( new Font("MSゴシック", Font.PLAIN, strSize) );					// 書式、文字サイズを設定
		label.setHorizontalAlignment(JLabel.CENTER);											// 水平方向中央揃え
		label.setVerticalAlignment(JLabel.CENTER);											// 垂直方向中央揃え
		label.setOpaque(opq);																			// ラベルの透明性を設定
	
	}
	
	// ボタンの設定を行うメソッド
	public static void setButton(JButton btn, ActionListener al, int x_size, int y_size, int strSize) {
		
		btn.setPreferredSize(new Dimension(x_size, y_size));							// 表示サイズを設定
		btn.setFont( new Font( "ＭＳゴシック", Font.PLAIN, strSize ) );			// 書式、文字サイズを設定
		btn.addActionListener(al);																	// ボタンが押されたときのイベントを受け取れるように設定
	}
	
	// マークに応じたアイコンオブジェクトを取得するメソッド
	public static ImageIcon getSuitIcon( int suit ) {
		ImageIcon icon = null;
		
		// マークに応じた画像を読み込んでリターンする
			switch(suit) {
			
				case 0 :		// スペード
					icon = new ImageIcon("./src/spade.png");			// アイコンが保存されている場所を格納する。
					break;
					
				case 1 : // ハート
					icon = new ImageIcon("./src/heart.png");
					break;
					
				case 2: // ダイヤ
					icon = new ImageIcon("./src/dia.png");
					break;
					
				case 3: // クラブ
					icon = new ImageIcon("./src/dia.png");
					break;
					
				default : // マークが不正の場合
					icon = null;
			}
	
		System.out.println("アイコンの場所呼ばれてる？" + icon);
		return icon;
	}
	
	// 数字に応じた表示文字列を取得するメソッド
	public static String getNoStr( int no ) {
			
		String No ;
		
		switch(no) {
			
			case 1 : // エース
				No = "A";
				break;
				
			case 11 : // ジャック
				No = "J";
				break;
				
			case 12 : // クイーン
				No = "Q";
				break;
				
			case 13 : // キング
				No = "K";
				break;
				
				default :		// 上記以外は数字をそのまま文字列として出力する
					No = String.valueOf(no);
		}
		
		return No;
	}
	
	
	
	
	
}
