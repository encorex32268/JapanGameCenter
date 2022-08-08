package com.lihan.japangamecenter.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lihan.japangamecenter.R
import com.lihan.japangamecenter.data.map.model.GameCenter

object Taito {
    val json = "[{\"name\":\"タイトーステーション 札幌狸小路2丁目店 \",\"address\":\"北海道札幌市中央区南三条西2-14\",\"lat\":43.058197,\"lng\":141.3386314},{\"name\":\"タイトーステーション イオンモール札幌平岡店 \",\"address\":\"北海道札幌市清田区平岡3条5-3-1 イオンモール札幌平岡 2F\",\"lat\":42.9967976,\"lng\":141.4581668},{\"name\":\"タイトーステーション イオンモール釧路昭和店 \",\"address\":\"北海道釧路市昭和中央4-18-1 イオンモール釧路昭和2F\",\"lat\":43.0265255,\"lng\":144.3598588},{\"name\":\"ハロータイトー 釧路貝塚 \",\"address\":\"北海道釧路市貝塚3丁目2-28\",\"lat\":42.9962437,\"lng\":144.4104657},{\"name\":\"タイトーステーション 千歳店 \",\"address\":\"北海道千歳市北栄2-12-5\",\"lat\":42.8334063,\"lng\":141.6450944},{\"name\":\"タイトーステーション 青森ガーラモール店 \",\"address\":\"青森県青森市三好2-3-19 マエダ西バイパス店2F\",\"lat\":40.832978,\"lng\":140.7025741},{\"name\":\"タイトーステーション 青森アムゼ店 \",\"address\":\"青森県青森市緑3-9-2 サンロード青森内\",\"lat\":40.8069546,\"lng\":140.7531638},{\"name\":\"タイトーＦステーション 八戸店　 \",\"address\":\"青森県八戸市三日町27\",\"lat\":40.5092425,\"lng\":141.4905758},{\"name\":\"ハロータイトー むつ \",\"address\":\"青森県むつ市小川町2-4-8 マエダストア4F\",\"lat\":41.29273,\"lng\":141.2076708},{\"name\":\"ハロータイトー イオン七戸十和田駅前 \",\"address\":\"青森県上北郡七戸町字荒熊内67番地990　イオン七戸十和田駅前店内\",\"lat\":40.7187099,\"lng\":141.155837},{\"name\":\"タイトーステーション 盛岡マッハランド店 \",\"address\":\"岩手県盛岡市上堂1-2-38\",\"lat\":39.7294008,\"lng\":141.1248484},{\"name\":\"タイトーFステーション 盛岡南店 \",\"address\":\"岩手県盛岡市津志田町2-1-77\",\"lat\":39.6569215,\"lng\":141.1548357},{\"name\":\"タイトーステーション 仙台クリスロード店 \",\"address\":\"宮城県仙台市青葉区中央2-3-25\",\"lat\":38.2609871,\"lng\":140.875646},{\"name\":\"タイトーステーション 仙台名掛丁店 \",\"address\":\"宮城県仙台市青葉区中央1-7-13\",\"lat\":38.2620384,\"lng\":140.8791255},{\"name\":\"タイトーステーション 仙台ベガロポリス店 \",\"address\":\"宮城県仙台市太白区西多賀5-24-1 ベガロポリス内\",\"lat\":38.2198064,\"lng\":140.8482998},{\"name\":\"タイトーFステーション 郡山アティ店 \",\"address\":\"福島県郡山市駅前1-16-7 郡山アティ7F\",\"lat\":37.3969754,\"lng\":140.3873675},{\"name\":\"タイトーFステーション 郡山オリエントパーク店 \",\"address\":\"福島県郡山市安積町荒井字大久保35-1\",\"lat\":37.3744815,\"lng\":140.3487627},{\"name\":\"Ｈｅｙ \",\"address\":\"東京都千代田区外神田1-10-5 廣瀬本社ビル1階～4階\",\"lat\":35.6990293,\"lng\":139.7710646},{\"name\":\"タイトーステーション 秋葉原店 \",\"address\":\"東京都千代田区外神田4-2-2 貴三ビル\",\"lat\":35.7002478,\"lng\":139.7717375},{\"name\":\"タイトーステーション 秋葉原東西自由通路店 \",\"address\":\"東京都千代田区神田佐久間町 1丁目6番1外\",\"lat\":35.6980296,\"lng\":139.7732719},{\"name\":\"タイトーステーション BIGBOX高田馬場店 \",\"address\":\"東京都新宿区高田馬場 1-35-3　BIGBOX 6F\",\"lat\":35.7125942,\"lng\":139.7042765},{\"name\":\"タイトーステーション 新宿東口店 \",\"address\":\"東京都新宿区新宿3-22-7 指田ビル\",\"lat\":35.6932171,\"lng\":139.7014682},{\"name\":\"タイトーステーション 新宿南口ゲームワールド店 \",\"address\":\"東京都新宿区新宿3-35-8\",\"lat\":35.6898545,\"lng\":139.7022641},{\"name\":\"タイトーステーション 浅草店 \",\"address\":\"東京都台東区浅草1-27-5\",\"lat\":35.7126081,\"lng\":139.7939141},{\"name\":\"タイトーステーション 上野アメ横店 \",\"address\":\"東京都台東区上野4-10-17\",\"lat\":35.7105625,\"lng\":139.7743603},{\"name\":\"タイトーステーション 上野御徒町店 \",\"address\":\"東京都台東区上野4-6-9\",\"lat\":35.7088677,\"lng\":139.7744533},{\"name\":\"タイトーステーション 錦糸町楽天地店 \",\"address\":\"東京都墨田区江東橋4-27-14楽天地ビルB1F\",\"lat\":35.696042,\"lng\":139.8153933},{\"name\":\"タイトーFステーション オリナス錦糸町店 \",\"address\":\"東京都墨田区太平4-1-2オリナスモール地下1階\",\"lat\":35.7006288,\"lng\":139.8160328},{\"name\":\"タイトーステーション BIGFUN平和島店   \",\"address\":\"東京都大田区平和島1-1-1BIGFUN平和島3F\",\"lat\":35.5839209,\"lng\":139.7406552},{\"name\":\"タイトーステーション 渋谷店 \",\"address\":\"東京都渋谷区渋谷1-24-12 渋谷東映プラザ\",\"lat\":35.6599453,\"lng\":139.7020329},{\"name\":\"タイトーステーション 池袋ロサ店 \",\"address\":\"東京都豊島区西池袋1-37-12 ロサ会館1F\",\"lat\":35.7323614,\"lng\":139.7092514},{\"name\":\"タイトーステーション 池袋西口店 \",\"address\":\"東京都豊島区西池袋1丁目15番9号第一西池ビル\",\"lat\":35.7305646,\"lng\":139.7097088},{\"name\":\"タイトーＦステーション 南大沢店 \",\"address\":\"東京都八王子市南大沢2－3 FＡＢ南大沢2F\",\"lat\":35.6145373,\"lng\":139.3801064},{\"name\":\"タイトーステーション 立川北口店 \",\"address\":\"東京都立川市曙町2-4-5OSJ TACHIKAWA 2F・3F\",\"lat\":35.6990139,\"lng\":139.4121973},{\"name\":\"タイトーFステーション 吉祥寺ＪＯＹ店 \",\"address\":\"東京都武蔵野市吉祥寺本町1-8-23\",\"lat\":35.7041889,\"lng\":139.5795301},{\"name\":\"タイトーステーション 府中くるる店 \",\"address\":\"東京都府中市宮町1丁目50番地\",\"lat\":35.671541,\"lng\":139.4816371},{\"name\":\"タイトーステーション 町田店 \",\"address\":\"東京都町田市原町田6-21-23 松山ビル\",\"lat\":35.5425877,\"lng\":139.4483288},{\"name\":\"タイトーステーション 国分寺店 \",\"address\":\"東京都国分寺市本町3-5-11Ｉビルディング\",\"lat\":35.7018627,\"lng\":139.4801126},{\"name\":\"タイトーFステーション ダイエー武蔵村山店 \",\"address\":\"東京都武蔵村山市伊奈平3-36-1ダイエー武蔵村山店2F\",\"lat\":35.7357143,\"lng\":139.3788623},{\"name\":\"タイトーステーション 多摩センター店 \",\"address\":\"東京都多摩市落合1-45-1 丘の上パティオ\",\"lat\":35.6230771,\"lng\":139.4263803},{\"name\":\"タイトーＦステーション イオンモール下妻店 \",\"address\":\"茨城県下妻市堀篭972-1 イオンモール下妻2F\",\"lat\":36.1901409,\"lng\":139.9897306},{\"name\":\"タイトーＦステーション トナリエクレオ つくば店 \",\"address\":\"茨城県つくば市吾妻1-7-1トナリエクレオ3F\",\"lat\":36.0811308,\"lng\":140.1120813},{\"name\":\"タイトーFステーション ヨークタウン坂東店 \",\"address\":\"茨城県坂東市辺田1104-1\",\"lat\":36.0372461,\"lng\":139.8899715},{\"name\":\"タイトーステーション 佐原東店 \",\"address\":\"茨城県稲敷市西代1495 パルナ2Ｆ\",\"lat\":35.9185676,\"lng\":140.4883225},{\"name\":\"タイトーステーション イオンタウン水戸南店 \",\"address\":\"茨城県東茨城郡茨城町長岡 3480-101\",\"lat\":36.3110727,\"lng\":140.4406681},{\"name\":\"タイトーFステーション トナリエ宇都宮店 \",\"address\":\"栃木県宇都宮市駅前通り1-4-6トナリエ宇都宮B1階\",\"lat\":36.5603167,\"lng\":139.89687},{\"name\":\"タイトーステーション 宇都宮ベルモール店 \",\"address\":\"栃木県宇都宮市陽東6-2-1 ベルモール宇都宮2F\",\"lat\":36.5555381,\"lng\":139.9284371},{\"name\":\"タイトーステーション 佐野新都市店 \",\"address\":\"栃木県佐野市高萩町1324-1\",\"lat\":36.2996418,\"lng\":139.6066422},{\"name\":\"タイトーＦステーション 小山店 \",\"address\":\"栃木県小山市喜沢1475ハーヴェストウォーク内スポーツシネマ棟\",\"lat\":36.3361666,\"lng\":139.8072599},{\"name\":\"タイトーFステーション VAL小山店 \",\"address\":\"栃木県小山市城山町3-3-22小山駅ビル（VAL小山）3階\",\"lat\":36.3130167,\"lng\":139.8060959},{\"name\":\"タイトーＦステーション 前橋リリカ店 \",\"address\":\"群馬県前橋市国領町2丁目14-1\",\"lat\":36.4046392,\"lng\":139.0679038},{\"name\":\"タイトーＦステーション  高崎オーパ店 \",\"address\":\"群馬県高崎市八島町46-1高崎オーパ 7F\",\"lat\":36.3232279,\"lng\":139.0111308},{\"name\":\"タイトーＦステーション ダイエー大宮店 \",\"address\":\"埼玉県さいたま市大宮区桜木町2-3大宮西口共同ビル（ダイエー内6Ｆ）\",\"lat\":35.9070025,\"lng\":139.6219},{\"name\":\"タイトーステーション 大宮店 \",\"address\":\"埼玉県さいたま市大宮区大門町1丁目1番地\",\"lat\":35.9057948,\"lng\":139.6252324},{\"name\":\"プレイランド イオン北浦和店 \",\"address\":\"埼玉県さいたま市浦和区常盤10-20-29イオン北浦和店3階\",\"lat\":35.8715215,\"lng\":139.6391024},{\"name\":\"タイトーＦステーション　クレアモール川越店 \",\"address\":\"埼玉県川越市新富町2-1-13\",\"lat\":35.9138263,\"lng\":139.4829221},{\"name\":\"タイトーステーション 所沢店 \",\"address\":\"埼玉県所沢市日吉町3-7 スカイビュウビル\",\"lat\":35.788112,\"lng\":139.4723831},{\"name\":\"タイトーＦステーション エルミこうのす店 \",\"address\":\"埼玉県鴻巣市本町1-1-2\",\"lat\":36.0605289,\"lng\":139.5094187},{\"name\":\"キッズランド マルイファミリー志木店 \",\"address\":\"埼玉県志木市本町5-26-1マルイファミリー志木店7階\",\"lat\":35.8232659,\"lng\":139.5742008},{\"name\":\"タイトーステーション 和光店 \",\"address\":\"埼玉県和光市丸山台1-4-5\",\"lat\":35.7866448,\"lng\":139.6138245},{\"name\":\"ラクガキ王国　三郷 \",\"address\":\"埼玉県三郷市ピアラシティ1-1-1 イトーヨーカドー三郷店2F\",\"lat\":35.8430707,\"lng\":139.8544294},{\"name\":\"タイトーステーション アリオ蘇我店 \",\"address\":\"千葉県千葉市中央区川崎町52-7 アリオ蘇我内\",\"lat\":35.5882105,\"lng\":140.1226083},{\"name\":\"タイトーFステーション イオン市川妙典店 \",\"address\":\"千葉県市川市妙典4-1-1 イオン市川妙典店2番街2階\",\"lat\":35.6925083,\"lng\":139.9267597},{\"name\":\"タイトーステーション 船橋店 \",\"address\":\"千葉県船橋市本町1-6-1\",\"lat\":35.7130862,\"lng\":139.9998126},{\"name\":\"タイトーFステーション イオン新松戸店 \",\"address\":\"千葉県松戸市新松戸3-2-2イオン新松戸店4階\",\"lat\":35.8255117,\"lng\":139.9155306},{\"name\":\"タイトーステーション 茂原アスモ店 \",\"address\":\"千葉県茂原市高師1735 茂原ショッピングプラザアスモ2F\",\"lat\":35.4348938,\"lng\":140.2878377},{\"name\":\"キッズパーク ボンベルタ成田店 \",\"address\":\"千葉県成田市赤坂2-1-10ボンベルタ成田3F\",\"lat\":35.7782162,\"lng\":140.2905394},{\"name\":\"タイトーステーション 旭サンモール店 \",\"address\":\"千葉県旭市イ-2676-1 サンモ－ル3F\",\"lat\":35.7250755,\"lng\":140.6593826},{\"name\":\"タイトーステーション セブンパークアリオ柏店 \",\"address\":\"千葉県柏市大島田1-6-1 セブンパークアリオ柏店3F\",\"lat\":35.8331644,\"lng\":140.0126859},{\"name\":\"タイトーFステーション 柏中央店 \",\"address\":\"千葉県柏市十余二249-5MEM内\",\"lat\":35.8847345,\"lng\":139.9526717},{\"name\":\"タイトーステーション 柏店 \",\"address\":\"千葉県柏市柏2-3-1 フーサワビル\",\"lat\":35.8614541,\"lng\":139.9727044},{\"name\":\"ハロータイトー 流山 \",\"address\":\"千葉県流山市流山9-800-2 イトーヨーカドー流山店内\",\"lat\":35.8500721,\"lng\":139.8991985},{\"name\":\"プレイランド　あびこ \",\"address\":\"千葉県我孫子市我孫子4-11-1あびこショッピングプラザ2F\",\"lat\":35.8765842,\"lng\":140.0089294},{\"name\":\"タイトーステーション 横浜西口五番街店 \",\"address\":\"神奈川県横浜市西区南幸1-12-9\",\"lat\":35.4646714,\"lng\":139.6195922},{\"name\":\"タイトーステーション イトーヨーカドー横浜別所店 \",\"address\":\"神奈川県横浜市南区別所1-14-1 イトーヨーカドー横浜別所店内\",\"lat\":35.4158985,\"lng\":139.594704},{\"name\":\"タイトーステーション 戸塚西口店 \",\"address\":\"神奈川県横浜市戸塚区戸塚町4023\",\"lat\":35.3995519,\"lng\":139.5318123},{\"name\":\"タイトーＦステーション 川崎ルフロン店 \",\"address\":\"神奈川県川崎市川崎区日進町1-11川崎ルフロン10階\",\"lat\":35.529545,\"lng\":139.6968379},{\"name\":\"タイトーステーション 溝の口店 \",\"address\":\"神奈川県川崎市高津区溝口1-11-8OKKA634ビル\",\"lat\":35.6000438,\"lng\":139.6124596},{\"name\":\"タイトーFステーション 向ヶ丘遊園店 \",\"address\":\"神奈川県川崎市多摩区登戸1718-1\",\"lat\":35.6205501,\"lng\":139.5620665},{\"name\":\"タイトーステーション 藤沢店 \",\"address\":\"神奈川県藤沢市南藤沢21-1\",\"lat\":35.3375297,\"lng\":139.4876833},{\"name\":\"タイトーステーション 小田原店 \",\"address\":\"神奈川県小田原市栄町1-3-12\",\"lat\":35.2549403,\"lng\":139.1561543},{\"name\":\"タイトーステーション 小田原シティーモール店 \",\"address\":\"神奈川県小田原市前川120 小田原シティーモールC棟2F\",\"lat\":35.2814915,\"lng\":139.1941451},{\"name\":\"タイトーFステーション イオン伊勢原店 \",\"address\":\"神奈川県伊勢原市白根630-1 イオン伊勢原店内\",\"lat\":35.3973372,\"lng\":139.2955591},{\"name\":\"プレイランド ダイエー海老名店 \",\"address\":\"神奈川県海老名市中央3-2-5ダイエー海老名店3階\",\"lat\":35.4506437,\"lng\":139.3906742},{\"name\":\"タイトーステーション 海老名ビナウォーク店 \",\"address\":\"神奈川県海老名市中央1-18-1 ビナウォーク6番館2F\",\"lat\":35.4526175,\"lng\":139.3946909},{\"name\":\"タイトーFステーション アル・プラザ鶴見店 \",\"address\":\"岐阜県大垣市鶴見町字上渡瀬641-2アル・プラザ鶴見店2階\",\"lat\":35.3591503,\"lng\":136.6423606},{\"name\":\"タイトーFステーション 静岡店 \",\"address\":\"静岡県静岡市葵区呉服町2丁目5番地4 ふしみや第2ビル\",\"lat\":34.9743998,\"lng\":138.383211},{\"name\":\"タイトーステーション 新浜松ザザシティ店 \",\"address\":\"静岡県浜松市中区鍛冶町15 ザザシティ西館2F\",\"lat\":34.704935,\"lng\":137.729802},{\"name\":\"タイトーFステーション イオンモール浜松市野店 \",\"address\":\"静岡県浜松市東区天王町1981-3 イオンモール浜松市野2F\",\"lat\":34.7398779,\"lng\":137.7630647},{\"name\":\"タイトーFステーション プレ葉ウォーク浜北店 \",\"address\":\"静岡県浜松市浜北区貴布祢1200 プレ葉ウォーク浜北2F\",\"lat\":34.7966536,\"lng\":137.7794801},{\"name\":\"タイトーＦステーション イオン富士宮店 \",\"address\":\"静岡県富士宮市浅間町1-8 イオンモール富士宮3F\",\"lat\":35.2208416,\"lng\":138.6117513},{\"name\":\"メルヘンランド ウェルディ長泉店 \",\"address\":\"静岡県駿東郡長泉町下長窪字城山1076-1 ウェルディ長泉2F\",\"lat\":35.148361,\"lng\":138.8907542},{\"name\":\"タイトーステーション 大須店 \",\"address\":\"愛知県名古屋市中区大須3丁目20-7\",\"lat\":35.1596801,\"lng\":136.9048017},{\"name\":\"タイトーステーション フェドラ大須店 \",\"address\":\"愛知県名古屋市中区大須3丁目30-31萬松寺駐車場ビル１階･2階\",\"lat\":35.1594813,\"lng\":136.9053596},{\"name\":\"キッズインタイトーイオン春日井店 \",\"address\":\"愛知県春日井市柏井町4丁目17番地　イオン春日井店３Fゲームコーナー\",\"lat\":35.2379876,\"lng\":136.961936},{\"name\":\"タイトーキッズランド　ＧＡＺＡ \",\"address\":\"愛知県豊田市喜多町1丁目140番地\",\"lat\":35.0879332,\"lng\":137.1573845},{\"name\":\"タイトーステーション パールシティ稲沢店 \",\"address\":\"愛知県稲沢市井之口大坪町80-1 パールシティ稲沢2F\",\"lat\":35.2371512,\"lng\":136.8190458},{\"name\":\"ファミリーランド　ドリーム \",\"address\":\"愛知県田原市田原町南新地76-1\",\"lat\":34.6723552,\"lng\":137.2745353},{\"name\":\"タイトーステーション 弥富店 \",\"address\":\"愛知県弥富市五明町蒲原1371-4\",\"lat\":35.1142725,\"lng\":136.7189553},{\"name\":\"タイトーステーション イオンモール明和店 \",\"address\":\"三重県多気郡明和町中村1223 イオンモール明和2F\",\"lat\":34.5811594,\"lng\":136.6141684},{\"name\":\"タイトーＦステーション イオン新潟西店 \",\"address\":\"新潟県新潟市西区小新南2丁目1番10号　イオン新潟西店3F\",\"lat\":37.8682902,\"lng\":138.9947052},{\"name\":\"タイトーFステーション 燕三条店 \",\"address\":\"新潟県燕市井土巻3-150 イオン県央店　アメニティ棟1F\",\"lat\":37.6509158,\"lng\":138.9356663},{\"name\":\"タイトーFステーション 上越店 \",\"address\":\"新潟県上越市富岡3524 J-MAXシアター内\",\"lat\":37.1483706,\"lng\":138.2593574},{\"name\":\"タイトーステーション ファボーレ婦中店 \",\"address\":\"富山県富山市婦中町下轡田165-1 フューチャーファボーレ2F\",\"lat\":36.6625745,\"lng\":137.1713494},{\"name\":\"メルヘンランド　ファボーレ婦中店 \",\"address\":\"富山県富山市婦中町下轡田165-1フューチャーファボーレ2F\",\"lat\":36.6625745,\"lng\":137.1714507},{\"name\":\"タイトーステーション 金沢店 \",\"address\":\"石川県金沢市片町2－1－7 宇都宮片町ビル\",\"lat\":36.5613307,\"lng\":136.6530571},{\"name\":\"手取フィッシュランド \",\"address\":\"石川県能美市粟生町ツ58\",\"lat\":36.4591199,\"lng\":136.5096889},{\"name\":\"タイトーFステーション アル・プラザ鯖江店 \",\"address\":\"福井県鯖江市下河端町16－6－1 アルプラザ鯖江アミューズ棟内\",\"lat\":35.9681014,\"lng\":136.1893855},{\"name\":\"タイトーFステーション ラザウォーク甲斐双葉店 \",\"address\":\"山梨県甲斐市志田字柿木616-1　ラザウォーク甲斐双葉　アミューズメント棟2F\",\"lat\":35.6852544,\"lng\":138.4820941},{\"name\":\"タイトーステーション イトーヨーカドー南松本店 \",\"address\":\"長野県松本市高宮中1-20 イトーヨーカドー南松本店3F\",\"lat\":36.2127001,\"lng\":137.9610797},{\"name\":\"タイトーステーション アイシティ２１松本店 \",\"address\":\"長野県東筑摩郡山形村山形7977 アイシティ21内\",\"lat\":36.1842122,\"lng\":137.8926526},{\"name\":\"タイトーFステーション イオン近江八幡店 \",\"address\":\"滋賀県近江八幡市鷹飼町南3-7　イオン近江八幡ショッピングセンター2番街内\",\"lat\":35.1211142,\"lng\":136.1037282},{\"name\":\"タイトーＦステーション イオンモール高の原店 \",\"address\":\"京都府木津川市相楽台1-1-1\",\"lat\":34.7253471,\"lng\":135.7905378},{\"name\":\"タイトーステーション 大阪日本橋店 \",\"address\":\"大阪府大阪市浪速区日本橋4-9-14\",\"lat\":34.6603999,\"lng\":135.5061701},{\"name\":\"タイトーＦステーション あべのアポロ店 \",\"address\":\"大阪府大阪市阿倍野区阿倍野筋1丁目5番31号 アポロビル4F\",\"lat\":34.6465412,\"lng\":135.511716},{\"name\":\"タイトーＦステーション 梅田店 \",\"address\":\"大阪府大阪市北区曽根崎2-16-26 曽根崎お初天神通り商店街内\",\"lat\":34.7014814,\"lng\":135.5004027},{\"name\":\"タイトーステーション 難波店 \",\"address\":\"大阪府大阪市中央区難波千日前15-12\",\"lat\":34.6633541,\"lng\":135.503188},{\"name\":\"タイトーステーション 摂津富田店 \",\"address\":\"大阪府高槻市大畑町13-1イオンフードスタイル摂津富田店 2F専門店街\",\"lat\":34.8375183,\"lng\":135.5893631},{\"name\":\"タイトーステーション アリオ八尾店 \",\"address\":\"大阪府八尾市光町2-3 イトーヨーカドーアリオ八尾3F\",\"lat\":34.632346,\"lng\":135.6059633},{\"name\":\"タイトーFステーション りんくうシークル店 \",\"address\":\"大阪府泉佐野市りんくう往来南3番地りんくうプレジャータウン シークル内\",\"lat\":34.4088471,\"lng\":135.2974153},{\"name\":\"タイトーＦステーション 住道店 \",\"address\":\"大阪府大東市赤井1丁目4番3号\",\"lat\":34.7085013,\"lng\":135.6195517},{\"name\":\"タイトーFステーション ダイエー湊川店 \",\"address\":\"兵庫県神戸市兵庫区荒田町2-18-20ダイエー湊川店3F\",\"lat\":34.6809903,\"lng\":135.166292},{\"name\":\"タイトーＦステーション HAT神戸店 \",\"address\":\"兵庫県神戸市中央区脇浜海岸通2-2-2 ブルメールHAT神戸2F\",\"lat\":34.6994569,\"lng\":135.2141274},{\"name\":\"タイトーFステーション 三宮西館店 \",\"address\":\"兵庫県神戸市中央区三宮町2-11-1三宮センタービル西館3階\",\"lat\":34.6914516,\"lng\":135.191647},{\"name\":\"タイトーＦステーション イオンフードスタイル神戸学園店 \",\"address\":\"兵庫県神戸市西区学園西町1-4\",\"lat\":34.6834733,\"lng\":135.0581498},{\"name\":\"タイトーFステーション 姫路店 \",\"address\":\"兵庫県姫路市駅前町270番地\",\"lat\":34.8285503,\"lng\":134.6917137},{\"name\":\"タイトーステーション 尼崎つかしん店 \",\"address\":\"兵庫県尼崎市塚口本町4-8-1 SCつかしん3F\",\"lat\":34.7614005,\"lng\":135.4189833},{\"name\":\"タイトーＦステーション イオン加古川店 \",\"address\":\"兵庫県加古川市平岡町新在家615-1\",\"lat\":34.7495938,\"lng\":134.862873},{\"name\":\"タイトーFステーション セントラルシティ和歌山店 \",\"address\":\"和歌山県和歌山市小雑貨805-1 セントラルシティ和歌山店１階\",\"lat\":34.1959268,\"lng\":135.1834374},{\"name\":\"タイトーFステーション オークワロマンシティ御坊店 \",\"address\":\"和歌山県御坊市湯川町財部180 オークワロマンシティ3F\",\"lat\":33.8977057,\"lng\":135.1488808},{\"name\":\"タイトーFステーション スーパーセンターオークワ南紀店 \",\"address\":\"和歌山県新宮市佐野3-11-19 スーパーセンターオークワ南紀店敷地内\",\"lat\":33.6739368,\"lng\":135.9705622},{\"name\":\"タイトーＦステーション マルナカ新倉敷店 \",\"address\":\"岡山県倉敷市玉島爪崎981-1\",\"lat\":34.562581,\"lng\":133.6854749},{\"name\":\"タイトーステーション 広島本通店 \",\"address\":\"広島県広島市中区本通3-5 せらかぐ本通ビル\",\"lat\":34.3928294,\"lng\":132.4604114},{\"name\":\"タイトーステーション 広島紙屋町店 \",\"address\":\"広島県広島市中区紙屋町2-2-21\",\"lat\":34.3940771,\"lng\":132.4560758},{\"name\":\"タイトーFステーション ゆめタウンみゆき店 \",\"address\":\"広島県広島市南区宇品西6丁目7-14\",\"lat\":34.3582169,\"lng\":132.4571308},{\"name\":\"タイトーステーション フジグラン緑井店 \",\"address\":\"広島県広島市安佐南区緑井1-5-2 フジグラン緑井3F\",\"lat\":34.4666834,\"lng\":132.4766006},{\"name\":\"タイトーステーション フジグラン神辺店 \",\"address\":\"広島県福山市神辺町大字新道上字2-10-26 フジグラン神辺店3F\",\"lat\":34.5452217,\"lng\":133.3577977},{\"name\":\"タイトーＦステーション ゆめタウン東広島店 \",\"address\":\"広島県東広島市西条土与丸一丁目5-7 ゆめタウン東広島4階\",\"lat\":34.4271804,\"lng\":132.7502238},{\"name\":\"タイトーＦステーション 山口メルクス店 \",\"address\":\"山口県山口市大字黒川82-1 ハイパーモールメルクス内\",\"lat\":34.13648,\"lng\":131.4341907},{\"name\":\"タイトーステーション フジグラン北島店 \",\"address\":\"徳島県板野郡北島町鯛浜字西ノ須174 フジグラン北島店内\",\"lat\":34.1122385,\"lng\":134.5468584},{\"name\":\"タイトーステーション 丸亀店 \",\"address\":\"香川県丸亀市川西町南1280-1 フジグラン丸亀バッハ棟2F\",\"lat\":34.241812,\"lng\":133.835329},{\"name\":\"タイトーステーション 衣山店 \",\"address\":\"愛媛県松山市衣山1-188 パルティ・フジ衣山内\",\"lat\":33.8535461,\"lng\":132.7463253},{\"name\":\"タイトーFステーション 今治ワールドプラザ店 \",\"address\":\"愛媛県今治市東村1-14-2 今治ワールドプラザ内\",\"lat\":34.0424439,\"lng\":133.0282236},{\"name\":\"タイトーFステーション 野市店 \",\"address\":\"高知県香南市野市町西野2007-1\",\"lat\":33.5593888,\"lng\":133.6963348},{\"name\":\"タイトーステーション リバーウォーク店 \",\"address\":\"福岡県北九州市小倉北区室町1-1-1 リバーウォーク北九州4F\",\"lat\":33.8858658,\"lng\":130.8753233},{\"name\":\"タイトーステーション サニーサイドモール小倉店 \",\"address\":\"福岡県北九州市小倉南区下曽根新町10-1 サニーサイドモール小倉3F\",\"lat\":33.8324588,\"lng\":130.9331255},{\"name\":\"タイトーFステーション ヨドバシ博多店 \",\"address\":\"福岡県福岡市博多区博多駅中央街6-12 ヨドバシカメラ4F\",\"lat\":33.5885827,\"lng\":130.4217388},{\"name\":\"タイトーステーション キャナルシティ博多店 \",\"address\":\"福岡県福岡市博多区住吉1-2-22 キャナルシティ博多4F\",\"lat\":33.5897266,\"lng\":130.4111423},{\"name\":\"タイトーステーション 福岡天神店 \",\"address\":\"福岡県福岡市中央区天神2ｰ6ｰ35 サザンクロスビル\",\"lat\":33.5896216,\"lng\":130.3973126},{\"name\":\"タイトーステーション マリノア店 \",\"address\":\"福岡県福岡市西区小戸2丁目12-30　マリノアシティ福岡2F\",\"lat\":33.5946202,\"lng\":130.3221883},{\"name\":\"プレイランド 筑紫野ベレッサ店 \",\"address\":\"福岡県筑紫野市美しが丘南1-12-1筑紫野ベレッサ2階\",\"lat\":33.4455783,\"lng\":130.54157},{\"name\":\"タイトーFステーション モラージュ佐賀店 \",\"address\":\"佐賀県佐賀市巨勢町大字牛島730モラージュ佐賀店2階\",\"lat\":33.2520488,\"lng\":130.318479},{\"name\":\"タイトーステーション アミュプラザ長崎店 \",\"address\":\"長崎県長崎市尾上町1-1 アミュプラザ長崎4F\",\"lat\":32.7516166,\"lng\":129.8703679},{\"name\":\"タイトーステーション 熊本下通店 \",\"address\":\"熊本県熊本市中央区新市街6-6いけおビル1F\",\"lat\":32.7992819,\"lng\":130.7074993},{\"name\":\"タイトーステーション 熊本下通セカンド店 \",\"address\":\"熊本県熊本市中央区新市街6-7カリーノセカンドビル\",\"lat\":32.7991784,\"lng\":130.7074708},{\"name\":\"タイトーステーション ゆめタウン八代店 \",\"address\":\"熊本県八代市建馬町3-1 ゆめタウン八代2F\",\"lat\":32.5058417,\"lng\":130.5856879},{\"name\":\"タイトーステーション ゆめタウン光の森店 \",\"address\":\"熊本県菊池郡菊陽町光の森7丁目33番地の1 ゆめタウン光の森2F\",\"lat\":32.8596107,\"lng\":130.7850723},{\"name\":\"タイトーFステーション セントポルタ大分店 \",\"address\":\"大分県大分市中央町2-1-1\",\"lat\":33.2368839,\"lng\":131.6049435},{\"name\":\"タイトーステーション アミュプラザおおいた店 \",\"address\":\"大分県大分市要町1番14号アミュプラザおおいた4F\",\"lat\":33.2331905,\"lng\":131.6064436},{\"name\":\"タイトーFステーション ゆめタウン別府店 \",\"address\":\"大分県別府市楠町382-7ゆめタウン別府店3階\",\"lat\":33.2762149,\"lng\":131.5075326},{\"name\":\"タイトーFステーション N\\u0027sCITY谷山店 \",\"address\":\"鹿児島県鹿児島市卸本町5-35N\\u0027sCITY谷山店2F\",\"lat\":31.5165838,\"lng\":130.5218598},{\"name\":\"タイトーステーション アミュプラザ鹿児島店 \",\"address\":\"鹿児島県鹿児島市中央町1-1 アミュプラザ鹿児島6F\",\"lat\":31.584321,\"lng\":130.5427861},{\"name\":\"タイトーＦステーション ニシムタ出水店 \",\"address\":\"鹿児島県出水市六月田町347\",\"lat\":32.1061403,\"lng\":130.3449862},{\"name\":\"タイトーFステーション イオンプラザ大島店 \",\"address\":\"鹿児島県奄美市名瀬小浜町23-1イオンプラザ大島店3階\",\"lat\":28.3840678,\"lng\":129.5009129},{\"name\":\"X-BOWL釧路 \",\"address\":\"北海道釧路市昭和中央4-18-1 イオンモール釧路昭和2F\",\"lat\":43.0265255,\"lng\":144.3598588},{\"name\":\"タイトーステーション 仙台ベガロポリス店（ボウリング） \",\"address\":\"宮城県仙台市太白区西多賀5-24-1 ベガロポリス内\",\"lat\":38.2198064,\"lng\":140.8482998},{\"name\":\"X-BOWL小田原 \",\"address\":\"神奈川県小田原市前川120 小田原シティモールC棟2F\",\"lat\":35.2814915,\"lng\":139.1941451},{\"name\":\"マリオンクレープ　札幌狸小路2丁目店 \",\"address\":\"北海道札幌市中央区南3条西2-14\",\"lat\":43.0549678,\"lng\":141.3365074},{\"name\":\"マリオンクレープ　仙台名掛丁店 \",\"address\":\"宮城県仙台市青葉区中央1-7-13\",\"lat\":38.2620384,\"lng\":140.8791255},{\"name\":\"ピコクレープ　秋葉原東西自由通路店 \",\"address\":\"東京都千代田区神田佐久間町1丁目6番1外\",\"lat\":35.6980296,\"lng\":139.7732719},{\"name\":\"マリオンクレープ　立川北口店 \",\"address\":\"東京都立川市曙町2-4-5OSJ TACHIKAWA 2F・3F\",\"lat\":35.6990139,\"lng\":139.4121973},{\"name\":\"マリオンクレープ　宇都宮ベルモール店 \",\"address\":\"栃木県宇都宮市陽東6-2-1 ベルモール2F\",\"lat\":36.5553252,\"lng\":139.9284371},{\"name\":\"マリオンクレープ　大宮店 \",\"address\":\"埼玉県さいたま市大宮区大門町1丁目1番地\",\"lat\":35.9057948,\"lng\":139.6252324},{\"name\":\"ピコクレープ　溝の口店 \",\"address\":\"神奈川県川崎市高津区溝口1丁目11-8\",\"lat\":35.6001171,\"lng\":139.6124918},{\"name\":\"マリオンクレープ　海老名店 \",\"address\":\"神奈川県海老名市中央区1-18-1 ビナウォーク六番館2F\",\"lat\":35.4525269,\"lng\":139.395485},{\"name\":\"マリオンクレープ　フェドラ大須店 \",\"address\":\"愛知県名古屋市中区大須3-30-31 萬松寺駐車場ビル\",\"lat\":35.1593922,\"lng\":136.9053508},{\"name\":\"マリオンクレープ　広島本通店 \",\"address\":\"広島県広島市中区本通3-5 せらかぐ本通ビル\",\"lat\":34.3928294,\"lng\":132.4604114},{\"name\":\"EXBAR TOKYO plus（エクスバー トウキョー プラス） \",\"address\":\"東京都新宿区新宿3-35-8ワールドビルB1F\",\"lat\":35.6912252,\"lng\":139.7021036},{\"name\":\"らくがキッズ \",\"address\":\"栃木県宇都宮市陽東6-2-1 ベルモール宇都宮2F\",\"lat\":36.5555381,\"lng\":139.9284371},{\"name\":\"NOBOLT（ノボルト） \",\"address\":\"福岡県福岡市西区小戸2-10-76\",\"lat\":33.5983584,\"lng\":130.3206852},{\"name\":\"brooming 浜松メイワン店 \",\"address\":\"静岡県浜松市中区砂山町6-1浜松駅ビル メイワン7F\",\"lat\":34.7041384,\"lng\":137.7344225},{\"name\":\"MEGARAGE（メガレイジ）溝の口 \",\"address\":\"神奈川県川崎市高津区溝口1丁目11-8 3F\",\"lat\":35.6001171,\"lng\":139.6124918},{\"name\":\"ガチャステ BIGBOX高田馬場店 \",\"address\":\"東京都新宿区高田馬場1-35-3BIGBOX 6F\",\"lat\":35.7120118,\"lng\":139.7038794},{\"name\":\"ガチャステ 府中くるる店 \",\"address\":\"東京都府中市宮町1丁目50番地　　\",\"lat\":35.671541,\"lng\":139.4816371},{\"name\":\"ガチャステ 大須店 \",\"address\":\"愛知県名古屋市中区大須3丁目20-7\",\"lat\":35.1596801,\"lng\":136.9048017}]\n"

    fun getTaitoStore() : List<GameCenter> {
        val gson = Gson()
        val typeToken = object : TypeToken<List<GameCenter>>(){}.type
        val result = gson.fromJson<List<GameCenter>?>(Taito.json,typeToken)
        result.forEach {
            it.copy(
                maker = "Taito"
            )
        }
        return result
    }


}