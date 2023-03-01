import java.util.ArrayList;
import java.util.List;

public class Player {
	
	// 手札の枚数
	final int TOTAL_HAND = 5;
	
	// プレイヤーが持っているカード情報
	private List<Card> hand;
	
	
	// コンストラクタ
	public Player(Deck deck) {
		
		hand = new ArrayList<Card>();		// オブジェクトの生成
		
//		// カード情報を初期化
//		for(Card card : hand) {
//			card.suit = 0;					// マーク
//			card.no = 0;					// 数字
//		}
		
		
		// 最初の手札ドロー
		for(int i = 0 ; i < TOTAL_HAND ; i++ )  {
			hand.add( i,deck.GetCard() );
		}	
	}
	
	public  void Draw ( Deck deck , int i ) {
		// ドローしたカード情報を手札にセット
		// 何枚ドローするかを判定するために捨てた手札の場所をGetCardで上書きしたい。
		// i = 上書きする手札の位置 複数ある場合はforで回す。
	
		hand.add( i, deck.GetCard() );
	}
	
	// どの位置のカードを取得するかを引数でもらう
	public int GetNo(int i) {
		return hand.get(i).no;
	}
	
	// どの位置のカードを取得するかを引数でもらう
	public int GetSuit(int i) {
		return hand.get(i).suit;
	}
	
	
	
	
	
}
