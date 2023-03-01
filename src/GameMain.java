
public class GameMain {

	public static void main(String[] args) {
		final int TOTAL_CARD = 52;			// カードの総数
		
		// 山札の生成
		Deck deck = new Deck();
		
		// 親が最初の手札を引く
		Player parent = new Player(deck);
		
		// 子が最初の手札を引く
		Player child = new Player(deck);
		
		// ゲーム画面を生成
		new Display( parent, child );
	}
}
