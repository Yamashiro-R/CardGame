import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// カード情報
class Card {
	int suit; 		// マーク (０：スペード／１：ハート／２：ダイヤ／３：クラブ)
	int no;		// 数字 (Ａ = １／Ｊ = １１／ Ｑ = １２／ Ｋ = １３)
}


// 山札クラス
public class Deck {
	
	final int TOTAL_CARD = 52;			// カードの総数

	// 0 ～ 12: スペードのA～K ／ 13 ～ 25 : ハートのA～K 
	//26 ～ 38：ダイヤのＡ～Ｋ ／ 39 ～ 51：クラブのＡ～Ｋ
	private List<Integer> cardList;
	
	// カードを取り出す位置（カード番号）（１枚引くたびに１加算）
	private int cardIndex = 0;
	
	// コンストラクタの定義
	public  Deck () {
		// カードの取り出す位置を初期化
		cardIndex = 0;
	
		cardList = new ArrayList<>();
		
		int arrayCard[] = new int[TOTAL_CARD]; 
		// 山札の初期化 
		for(int i=0 ; i < TOTAL_CARD ; i++) {
			cardList.add( i ); 
		}
		// 山札をpする
		Collections.shuffle(cardList);
	}
	
	public Card GetCard() {
		
		// 山札からカードを１枚取り出し、そのカードとマークと数字をリターンする
		Card cardInfo = new Card();		// カード情報格納用
		int cardNo = 0;		// カード番号
		
		// カードを１枚取り出して、カード番号（１～５１のいずれか）を取得
		cardNo = cardList.get(cardIndex);		
		
		// １枚カードを取り出したので 
		cardIndex++;
		
		// 山札をすべて引いた場合は、山札を初期化　
		if(  TOTAL_CARD <= cardIndex) {
			cardIndex = 0;						// 先頭に戻す
			Collections.shuffle(cardList);		// 山札シャッフル
		}
		
		cardInfo.suit = cardNo / 13;				// マーク = カード番号を１３で割った商
		cardInfo.no = ( cardNo / 13 ) + 1;	// 数字 = カード番号を１３で割ったあまり＋１
		
		return cardInfo;
 		
		
	}
	
	
}
