/*
 * 文 件 名:  IreadCollator.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  h00101670
 * 修改时间:  2009-2-10
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.example.springbootdemo2021.util;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Comparator;
import java.util.Locale;

/**
 * 中文字符比较器
 * 
 * @author h00101670
 * @version [版本号, 2009-2-10]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class IreadCollator implements Comparator, Comparable
{

    /**
     * 比较器
     */
    private static RuleBasedCollator GB2312Collator = getGB2312Collator();

    /**
     * 起始字符串
     */
    private String baseString = "";

    /**
     * 中文排序规则
     */
    private static final String GB2312Chars = "吖<阿<啊<锕<嗄<哎<哀<唉<埃<挨<锿<捱<皑<癌<嗳<矮<蔼<霭<艾<爱<砹<隘<嗌<嫒<碍<暧<瑷<安<桉<氨<庵<谙<鹌<鞍 <俺<埯<铵<揞<犴<岸<按<案<胺<暗<黯<肮<昂<盎<凹<坳<敖<嗷<廒<獒<遨<熬<翱<聱<螯<鳌<鏖<拗<袄<媪<岙<傲<奥<骜<澳<懊<鏊"
        + "<八<巴<叭<扒<吧<岜<芭<疤<捌<笆<粑<拔<茇<菝<跋<魃<把<钯<靶<坝<爸<罢<鲅<霸<灞<掰<白<百<佰<柏<捭<摆<呗<败 <拜<稗<扳<班<般<颁<斑<搬<瘢<癍<阪<坂<板<版<钣<舨<办<半<伴<扮<拌<绊<瓣<邦<帮<梆<浜<绑<榜<膀<蚌<傍<棒<谤<蒡<磅<镑<勹<包<孢<苞<胞<煲<龅<褒<雹<宝<饱<保<鸨<堡<葆<褓<报<抱<豹<趵<鲍<暴<爆<陂<卑<杯<悲<碑<鹎<北<贝<狈<邶<备<背<钡<倍<悖<被<惫<焙<辈<碚<蓓<褙<鞴<鐾<奔<贲<锛<本<苯<畚<坌<笨<崩<绷<嘣<甭<泵<迸<甏<蹦<逼<荸<鼻<匕<比<吡<妣<彼<秕<俾<笔<舭<鄙<币<必<毕<闭<庇<畀<哔<毖<荜<陛<毙<狴<铋<婢<庳<敝<萆<弼<愎<筚<滗<痹<蓖<裨<跸<辟<弊<碧<箅<蔽<壁<嬖<篦<薜<避<濞<臂<髀<璧<襞<边<砭<笾<编<煸<蝙<鳊<鞭<贬<扁<窆<匾<碥<褊<卞<弁<忭<汴<苄<拚<便<变<缏<遍<辨<辩<辫<灬<杓<彪<标<飑<髟<骠<膘<瘭<镖<飙<飚<镳<表<婊<裱<鳔<憋<鳖<别<蹩<瘪<宾<彬<傧<斌<滨<缤<槟<镔<濒<豳< 摈<殡<膑<髌<鬓<冫<冰<兵<丙<邴<秉<柄<炳 <饼<禀<并<病<摒<拨<波<玻<剥<钵<饽<啵< 脖<菠<播<伯<孛<驳<帛<泊<勃<亳<钹<铂<舶 <博<渤<鹁<搏<箔<膊<踣<薄<礴<跛<簸<擘< 檗<逋<钸<晡<醭<卜<卟<补<哺<捕<不<布<步<怖<钚<部<埠<瓿<簿"
        + "<嚓<擦<礤<猜<才<材<财<裁<采<彩<睬<踩<菜<蔡<参< 骖<餐<残<蚕<惭<惨<黪<灿<粲<璨<仓<伧<沧 <苍<舱<藏<操<糙<曹<嘈<漕<槽<艚<螬<艹< 草<册<侧<厕<恻<测<策<岑<涔<噌<层<蹭<叉 <杈<插<馇<锸<查<茬<茶<搽<猹<槎<察<碴< 檫<衩<镲<汊<岔<诧<姹<差<拆<钗<侪<柴<豺 <虿<瘥<觇<掺<搀<婵<谗<孱<禅<馋<缠<蝉< 廛<潺<镡<蟾<躔<产<谄<铲<阐<蒇<冁<忏<颤 <羼<伥<昌<娼<猖<菖<阊<鲳<长<肠<苌<尝< 偿<常<徜<嫦<厂<场<昶<惝<敞<氅<怅<畅<倡 <鬯<唱<抄<怊<钞<焯<超<晁<巢<朝<嘲<潮< 吵<炒<耖<车<砗<扯<屮<彻<坼<掣<撤<澈<抻 <郴<琛<嗔<尘<臣<忱<沉<辰<陈<宸<晨<谌< 碜<闯<衬<称<龀<趁<榇<谶<柽<蛏<铛<撑<瞠 <丞<成<呈<承<枨<诚<城<乘<埕<铖<惩<程< 裎<塍<酲<澄<橙<逞<骋<秤<吃<哧<蚩<鸱<眵 <笞<嗤<媸<痴<螭<魑<弛<池<驰<迟<茌<持< 匙<墀<踟<篪<尺<侈<齿<耻<豉<褫<彳<叱<斥 <赤<饬<炽<翅<敕<啻<傺<瘛<充<冲<忡<茺< 舂<憧<艟<虫<崇<宠<铳<抽<瘳<仇<俦<帱<惆 <绸<畴<愁<稠<筹<酬<踌<雠<丑<瞅<臭<出< 初<樗<刍<除<厨<滁<锄<蜍<雏<橱<躇<蹰<杵 <础<储<楮<楚<褚<亍<处<怵<绌<搐<触<憷< 黜<矗<搋<揣<啜<嘬<踹<巛<川<氚<穿<传<舡 <船<遄<椽<舛<喘<串<钏<囱<疮<窗<床<创< 怆<吹<炊<垂<陲<捶<棰<槌<锤<春<椿<蝽<纯 <唇<莼<淳<鹑<醇<蠢<踔<戳<辶<绰<辍<龊< 呲<疵<词<祠<茈<茨<瓷<慈<辞<磁<雌<鹚<糍 <此<次<刺<赐<从<匆<苁<枞<葱<骢<璁<聪< 丛<淙<琮<凑<楱<腠<辏<粗<徂<殂<促<猝<酢 <蔟<醋<簇<蹙<蹴<汆<撺<镩<蹿<窜<篡<爨< 崔<催<摧<榱<璀<脆<啐<悴<淬<萃<毳<瘁<粹 <翠<村<皴<存<忖<寸<搓<磋<撮<蹉<嵯<痤< 矬<鹾<脞<厝<挫<措<锉<错"
        + "<哒< 耷<搭<嗒<褡<达<妲<怛<沓<笪<答<瘩<靼<鞑 <打<大<呆<呔<歹<傣<代<岱<甙<绐<迨<带< 待<怠<殆<玳<贷<埭<袋<逮<戴<黛<丹<单<担 <眈<耽<郸<聃<殚<瘅<箪<儋<胆<疸<掸<旦< 但<诞<啖<弹<惮<淡<萏<蛋<氮<澹<当<裆<挡 <党<谠<凼<宕<砀<荡<档<菪<刀<刂<叨<忉< 氘<导<岛<倒<捣<祷<蹈<到<悼<焘<盗<道<稻 <纛<得<锝<德<的<灯<登<噔<簦<蹬<等<戥< 邓<凳<嶝<瞪<磴<镫<低<羝<堤<嘀<滴<镝<狄 <籴<迪<敌<涤<荻<笛<觌<嫡<氐<诋<邸<坻< 底<抵<柢<砥<骶<地<弟<帝<娣<递<第<谛<棣 <睇<缔<蒂<碲<嗲<掂<滇<颠<巅<癫<典<点< 碘<踮<电<佃<甸<阽<坫<店<垫<玷<钿<惦<淀 <奠<殿<靛<癜<簟<刁<叼<凋<貂<碉<雕<鲷< 吊<钓<调<掉<铞<爹<跌<迭<垤<瓞<谍<喋<堞 <揲<耋<叠<牒<碟<蝶<蹀<鲽<丁<仃<叮<玎< 疔<盯<钉<耵<酊<顶<鼎<订<定<啶<腚<碇<锭 <丢<铥<东<冬<咚<岽<氡<鸫<董<懂<动<冻< 侗<垌<峒<恫<栋<洞<胨<胴<硐<都<兜<蔸<篼 <斗<抖<钭<陡<蚪<豆<逗<痘<窦<嘟<督<毒< 读<渎<椟<牍<犊<黩<髑<独<笃<堵<赌<睹<芏 <妒<杜<肚<度<渡<镀<蠹<端<短<段<断<缎< 椴<煅<锻<簖<堆<队<对<兑<怼<碓<憝<镦<吨 <敦<墩<礅<蹲<盹<趸<囤<沌<炖<盾<砘<钝< 顿<遁<多<咄<哆<裰<夺<铎<掇<踱<朵<哚<垛 <缍<躲<剁<沲<堕<舵<惰<跺"
        + "<屙 <讹<俄<娥<峨<莪<锇<鹅<蛾<额<婀<厄<呃< 扼<苊<轭<垩<恶<饿<谔<鄂<阏<愕<萼<遏<腭 <锷<鹗<颚<噩<鳄<恩<蒽<摁<儿<而<鸸<鲕< 尔<耳<迩<洱<饵<珥<铒<二<佴<贰"
        + "<发<乏<伐<垡<罚<阀<筏<法<砝<珐<帆 <番<幡<翻<藩<凡<矾<钒<烦<樊<蕃<燔<繁< 蹯<蘩<反<返<犯<泛<饭<范<贩<畈<梵<匚<方 <邡<坊<芳<枋<钫<防<妨<房<肪<鲂<仿<访< 彷<纺<舫<放<飞<妃<非<啡<绯<菲<扉<蜚<霏 <鲱<肥<淝<腓<匪<诽<悱<斐<榧<翡<篚<吠< 废<沸<狒<肺<费<痱<镄<分<吩<纷<芬<氛<玢 <酚<坟<汾<棼<焚<鼢<粉<份<奋<忿<偾<愤< 粪<鲼<瀵<丰<风<沣<枫<封<疯<砜<峰<烽<葑 <锋<蜂<酆<冯<逢<缝<讽<唪<凤<奉<俸<佛< 缶<否<夫<呋<肤<趺<麸<稃<跗<孵<敷<弗<伏 <凫<孚<扶<芙<芾<怫<拂<服<绂<绋<苻<俘< 氟<祓<罘<茯<郛<浮<砩<莩<蚨<匐<桴<涪<符 <艴<菔<袱<幅<福<蜉<辐<幞<蝠<黻<呒<抚< 甫<府<拊<斧<俯<釜<脯<辅<腑<滏<腐<黼<阝 <父<讣<付<妇<负<附<咐<阜<驸<复<赴<副< 傅<富<赋<缚<腹<鲋<赙<蝮<鳆<覆<馥"
        + "<旮<伽<钆<尜<嘎<噶<尕<尬<该<陔<垓 <赅<改<丐<钙<盖<溉<戤<概<干<甘<杆<肝< 坩<泔<苷<柑<竿<疳<酐<尴<秆<赶<敢<感<澉 <橄<擀<旰<矸<绀<淦<赣<冈<刚<岗<纲<肛< 缸<钢<罡<港<杠<筻<戆<皋<羔<高<槔<睾<膏 <篙<糕<杲<搞<缟<槁<稿<镐<藁<告<诰<郜< 锆<戈<圪<纥<疙<哥<胳<袼<鸽<割<搁<歌<阁 <革<格<鬲<葛<蛤<隔<嗝<塥<搿<膈<镉<骼< 哿<舸<个<各<虼<硌<铬<给<根<跟<哏<亘<艮 <茛<更<庚<耕<赓<羹<哽<埂<绠<耿<梗<鲠< 工<弓<公<功<攻<供<肱<宫<恭<蚣<躬<龚<觥 <廾<巩<汞<拱<珙<共<贡<勾<佝<沟<钩<缑< 篝<鞲<岣<狗<苟<枸<笱<构<诟<购<垢<够<媾 <彀<遘<觏<估<咕<姑<孤<沽<轱<鸪<菇<菰< 蛄<觚<辜<酤<毂<箍<鹘<古<汩<诂<谷<股<牯 <骨<罟<钴<蛊<鹄<鼓<嘏<臌<瞽<固<故<顾< 崮<梏<牿<雇<痼<锢<鲴<瓜<刮<胍<鸹<呱<剐 <寡<卦<诖<挂<褂<乖<拐<怪<关<观<官<冠< 倌<棺<鳏<馆<管<贯<惯<掼<涫<盥<灌<鹳<罐 <光<咣<桄<胱<广<犷<逛<归<圭<妫<龟<规< 皈<闺<硅<瑰<鲑<宄<轨<庋<匦<诡<癸<鬼<晷 <簋<刽<刿<柜<炅<贵<桂<跪<鳜<丨<衮<绲< 辊<滚<磙<鲧<棍<呙<埚<郭<崞<聒<锅<蝈<国 <帼<掴<虢<馘<果<猓<椁<蜾<裹<过"
        + "<铪<哈<嗨<孩<骸<海<胲<醢<亥<骇<害 <氦<顸<蚶<酣<憨<鼾<邗<含<邯<函<晗<涵< 焓<寒<韩<罕<喊<汉<汗<旱<悍<捍<焊<菡<颔 <撖<憾<撼<翰<瀚<夯<杭<绗<航<颃<沆<蒿< 嚆<薅<蚝<毫<嗥<豪<嚎<壕<濠<好<郝<号<昊 <浩<耗<皓<颢<灏<诃<呵<喝<嗬<禾<合<何< 劾<和<河<曷<阂<核<盍<荷<涸<盒<菏<蚵<颌 <貉<阖<翮<贺<褐<赫<鹤<壑<黑<嘿<痕<很< 狠<恨<亨<哼<恒<桁<珩<横<衡<蘅<轰<哄<訇 <烘<薨<弘<红<宏<闳<泓<洪<荭<虹<鸿<蕻< 黉<讧<侯<喉<猴<瘊<篌<糇<骺<吼<后<厚<後 <逅<候<堠<鲎<乎<虍<呼<忽<烀<轷<唿<惚< 滹<囫<弧<狐<胡<壶<斛<湖<猢<葫<煳<瑚<鹕 <槲<糊<蝴<醐<觳<虎<浒<唬<琥<互<户<冱< 护<沪<岵<怙<戽<祜<笏<扈<瓠<鹱<花<华<哗 <骅<铧<滑<猾<化<划<画<话<桦<怀<徊<淮< 槐<踝<坏<欢<獾<还<环<郇<洹<桓<萑<锾<寰 <缳<鬟<缓<幻<奂<宦<唤<换<浣<涣<患<焕< 逭<痪<豢<漶<鲩<擐<肓<荒<慌<皇<凰<隍<黄 <徨<惶<湟<遑<煌<潢<璜<篁<蝗<癀<磺<簧< 蟥<鳇<恍<晃<谎<幌<灰<诙<咴<恢<挥<虺<晖 <珲<辉<麾<徽<隳<回<洄<茴<蛔<悔<卉<汇< 会<讳<哕<浍<绘<荟<诲<恚<桧<烩<贿<彗<晦 <秽<喙<惠<缋<毁<慧<蕙<蟪<昏<荤<婚<阍< 浑<馄<魂<诨<混<溷<耠<锪<劐<豁<攉<活<火 <伙<钬<夥<或<货<获<祸<惑<霍<镬<嚯<藿< 蠖"
        + "<丌<讥<击<叽<饥<乩<圾<机< 玑<肌<芨<矶<鸡<咭<迹<剞<唧<姬<屐<积<笄 <基<绩<嵇<犄<缉<赍<畸<跻<箕<畿<稽<齑< 墼<激<羁<及<吉<岌<汲<级<即<极<亟<佶<急 <笈<疾<戢<棘<殛<集<嫉<楫<蒺<辑<瘠<蕺< 籍<几<己<虮<挤<脊<掎<戟<嵴<麂<彐<计<记 <伎<纪<妓<忌<技<芰<际<剂<季<哜<既<洎< 济<继<觊<偈<寂<寄<悸<祭<蓟<暨<跽<霁<鲚 <稷<鲫<冀<髻<骥<加<夹<佳<迦<枷<浃<珈< 家<痂<笳<袈<袷<葭<跏<嘉<镓<岬<郏<荚<恝 <戛<铗<蛱<颊<甲<胛<贾<钾<瘕<价<驾<架< 假<嫁<稼<戋<奸<尖<坚<歼<间<肩<艰<兼<监 <笺<菅<湔<犍<缄<搛<煎<缣<蒹<鲣<鹣<鞯< 囝<拣<枧<俭<柬<茧<捡<笕<减<剪<检<趼<睑 <硷<裥<锏<简<谫<戬<碱<翦<謇<蹇<见<件< 建<饯<剑<牮<荐<贱<健<涧<舰<渐<谏<楗<毽 <溅<腱<践<鉴<键<僭<槛<箭<踺<江<姜<将< 茳<浆<豇<僵<缰<礓<疆<讲<奖<桨<蒋<耩<匠 <降<洚<绛<酱<犟<糨<艽<交<郊<姣<娇<浇< 茭<骄<胶<椒<焦<蛟<跤<僬<鲛<蕉<礁<鹪<角 <佼<侥<挢<狡<绞<饺<皎<矫<脚<铰<搅<湫< 剿<敫<徼<缴<叫<峤<轿<较<教<窖<酵<噍<醮 <阶<疖<皆<接<秸<喈<嗟<揭<街<卩<孑<节< 讦<劫<杰<诘<拮<洁<结<桀<婕<捷<颉<睫<截 <碣<竭<鲒<羯<她<姐<解<介<戒<芥<届<界< 疥<诫<借<蚧<骱<藉<巾<今<斤<钅<金<津<矜 <衿<筋<襟<仅<卺<紧<堇<谨<锦<廑<馑<槿< 瑾<尽<劲<妗<近<进<荩<晋<浸<烬<赆<缙<禁 <靳<觐<噤<京<泾<经<茎<荆<惊<旌<菁<晶< 腈<睛<粳<兢<精<鲸<井<阱<刭<肼<颈<景<儆 <憬<警<净<弪<径<迳<胫<痉<竞<婧<竟<敬< 靓<靖<境<獍<静<镜<冂<扃<迥<炯<窘<纠<究 <鸠<赳<阄<啾<揪<鬏<九<久<灸<玖<韭<酒< 旧<臼<咎<疚<柩<桕<厩<救<就<舅<僦<鹫<居 <拘<狙<苴<驹<疽<掬<椐<琚<趄<锔<裾<雎< 鞠<鞫<局<桔<菊<橘<咀<沮<举<矩<莒<榉<榘 <龃<踽<句<巨<讵<拒<苣<具<炬<钜<俱<倨< 剧<惧<据<距<犋<飓<锯<窭<聚<屦<踞<遽<瞿 <醵<娟<捐<涓<鹃<镌<蠲<卷<锩<倦<桊<狷< 绢<隽<眷<鄄<噘<撅<孓<决<诀<抉<珏<绝<觉 <倔<崛<掘<桷<觖<厥<劂<谲<獗<蕨<噱<橛< 爵<镢<蹶<嚼<矍<爝<攫<军<君<均<钧<皲<菌 <筠<麇<俊<郡<峻<捃<浚<骏<竣"
        + "<咔<咖<喀<卡<佧<胩<开<揩<锎<凯<剀<垲 <恺<铠<慨<蒈<楷<锴<忾<刊<勘<龛<堪<戡< 坎<侃<砍<莰<看<阚<瞰<康<慷<糠<扛<亢<伉 <抗<闶<炕<钪<尻<考<拷<栲<烤<铐<犒<靠< 坷<苛<柯<珂<科<轲<疴<钶<棵<颏<稞<窠<颗 <瞌<磕<蝌<髁<壳<咳<可<岢<渴<克<刻<客< 恪<课<氪<骒<缂<嗑<溘<锞<肯<垦<恳<啃<裉 <吭<坑<铿<空<倥<崆<箜<孔<恐<控<抠<芤< 眍<口<叩<扣<寇<筘<蔻<刳<枯<哭<堀<窟<骷 <苦<库<绔<喾<裤<酷<夸<侉<垮<挎<胯<跨< 蒯<块<快<侩<郐<哙<狯<脍<筷<宽<髋<款<匡 <诓<哐<筐<狂<诳<夼<邝<圹<纩<况<旷<矿< 贶<框<眶<亏<岿<悝<盔<窥<奎<逵<馗<喹<揆 <葵<暌<魁<睽<蝰<夔<傀<跬<匮<喟<愦<愧< 溃<蒉<馈<篑<聩<坤<昆<琨<锟<髡<醌<鲲<悃 <捆<阃<困<扩<括<栝<蛞<阔<廓"
        + "<垃<拉<啦<邋<旯<砬<喇<剌<腊<瘌<蜡<辣 <来<崃<徕<涞<莱<铼<赉<睐<赖<濑<癞<籁< 兰<岚<拦<栏<婪<阑<蓝<谰<澜<褴<斓<篮<镧 <览<揽<缆<榄<漤<罱<懒<烂<滥<啷<郎<狼< 莨<廊<琅<榔<稂<锒<螂<朗<阆<浪<蒗<捞<劳 <牢<唠<崂<痨<铹<醪<老<佬<姥<栳<铑<潦< 涝<烙<耢<酪<仂<乐<叻<泐<勒<鳓<雷<嫘<缧 <檑<镭<羸<耒<诔<垒<磊<蕾<儡<肋<泪<类< 累<酹<擂<嘞<塄<棱<楞<冷<愣<厘<梨<狸<离 <莉<骊<犁<喱<鹂<漓<缡<蓠<蜊<嫠<璃<鲡< 黎<篱<罹<藜<黧<蠡<礼<李<里<俚<哩<娌<逦 <理<锂<鲤<澧<醴<鳢<力<历<厉<立<吏<丽< 利<励<呖<坜<沥<苈<例<戾<枥<疠<隶<俐<俪 <栎<疬<荔<轹<郦<栗<猁<砺<砾<莅<唳<笠< 粒<粝<蛎<傈<痢<詈<跞<雳<溧<篥<俩<奁<连 <帘<怜<涟<莲<联<裢<廉<鲢<濂<臁<镰<蠊< 敛<琏<脸<裣<蔹<练<娈<炼<恋<殓<链<楝<潋 <良<凉<梁<椋<粮<粱<墚<踉<两<魉<亮<谅< 辆<晾<量<辽<疗<聊<僚<寥<廖<嘹<寮<撩<獠 <缭<燎<镣<鹩<钌<蓼<了<尥<料<撂<咧<列< 劣<冽<洌<埒<烈<捩<猎<裂<趔<躐<鬣<邻<林 <临<啉<淋<琳<粼<嶙<遴<辚<霖<瞵<磷<鳞< 麟<凛<廪<懔<檩<吝<赁<蔺<膦<躏<拎<伶<灵 <囹<岭<泠<苓<柃<玲<瓴<凌<铃<陵<棂<绫< 羚<翎<聆<菱<蛉<零<龄<鲮<酃<领<令<另<呤 <溜<熘<刘<浏<流<留<琉<硫<旒<遛<馏<骝< 榴<瘤<镏<鎏<柳<绺<锍<六<鹨<咯<龙<咙<泷 <茏<栊<珑<胧<砻<笼<聋<隆<癃<窿<陇<垄< 垅<拢<娄<偻<喽<蒌<楼<耧<蝼<髅<嵝<搂<篓 <陋<漏<瘘<镂<露<噜<撸<卢<庐<芦<垆<泸< 炉<栌<胪<轳<鸬<舻<颅<鲈<卤<虏<掳<鲁<橹 <镥<陆<录<赂<辂<渌<逯<鹿<禄<滤<碌<路< 漉<戮<辘<潞<璐<簏<鹭<麓<氇<驴<闾<榈<吕 <侣<旅<稆<铝<屡<缕<膂<褛<履<律<虑<率< 绿<氯<孪<峦<挛<栾<鸾<脔<滦<銮<卵<乱<掠 <略<锊<抡<仑<伦<囵<沦<纶<轮<论<捋<罗< 猡<脶<萝<逻<椤<锣<箩<骡<镙<螺<倮<裸<瘰 <蠃<泺<洛<络<荦<骆<珞<落<摞<漯<雒"
        + "<妈<嬷<麻<蟆<马<犸<玛<码<蚂 <杩<骂<唛<吗<嘛<埋<霾<买<荬<劢<迈<麦< 卖<脉<颟<蛮<馒<瞒<鞔<鳗<满<螨<曼<谩<墁 <幔<慢<漫<缦<蔓<熳<镘<邙<忙<芒<盲<茫< 硭<莽<漭<蟒<猫<毛<矛<牦<茅<旄<蛑<锚<髦 <蝥<蟊<卯<峁<泖<茆<昴<铆<茂<冒<贸<耄< 袤<帽<瑁<瞀<貌<懋<么<没<枚<玫<眉<莓<梅 <媒<嵋<湄<猸<楣<煤<酶<镅<鹛<霉<每<美< 浼<镁<妹<昧<袂<媚<寐<魅<门<扪<钔<闷<焖 <懑<们<氓<虻<萌<盟<甍<瞢<朦<檬<礞<艨< 勐<猛<蒙<锰<艋<蜢<懵<蠓<孟<梦<咪<弥<祢 <迷<猕<谜<醚<糜<縻<麋<靡<蘼<米<芈<弭< 敉<脒<眯<冖<糸<汨<宓<泌<觅<秘<密<幂<谧 <嘧<蜜<宀<眠<绵<棉<免<沔<黾<勉<眄<娩< 冕<湎<缅<腼<面<喵<苗<描<瞄<鹋<杪<眇<秒 <淼<渺<缈<藐<邈<妙<庙<乜<咩<灭<蔑<篾< 蠛<民<岷<玟<苠<珉<缗<皿<闵<抿<泯<闽<悯 <敏<愍<鳘<名<明<鸣<茗<冥<铭<溟<暝<瞑< 螟<酩<命<谬<缪<摸<谟<嫫<馍<摹<模<膜<麽 <摩<磨<蘑<魔<抹<末<殁<沫<茉<陌<秣<莫< 寞<漠<蓦<貊<墨<瘼<镆<默<貘<耱<哞<牟<侔 <眸<谋<鍪<某<母<毪<亩<牡<姆<拇<木<仫< 目<沐<坶<牧<苜<钼<募<墓<幕<睦<慕<暮<穆"
        + "<拿<镎<哪<内<那<纳<肭<娜<衲 <钠<捺<乃<奶<艿<氖<奈<柰<耐<萘<鼐<囡< 男<南<难<喃<楠<赧<腩<蝻<囔<囊<馕<曩<攮 <孬<呶<挠<硇<铙<猱<蛲<垴<恼<脑<瑙<闹< 淖<疒<讷<呐<呢<馁<嫩<能<嗯<妮<尼<坭<怩 <泥<倪<铌<猊<霓<鲵<伲<你<拟<旎<昵<逆< 匿<溺<睨<腻<拈<年<鲇<鲶<黏<捻<辇<撵<碾 <廿<念<埝<娘<酿<鸟<茑<袅<嬲<尿<脲<捏< 肀<陧<涅<聂<臬<啮<嗫<镊<镍<颞<蹑<孽<蘖 <您<宁<咛<拧<狞<柠<聍<凝<佞<泞<甯<妞< 牛<忸<扭<狃<纽<钮<农<侬<哝<浓<脓<弄<耨 <奴<孥<驽<努<弩<胬<怒<女<钕<恧<衄<疟< 虐<暖<挪<傩<诺<喏<搦<锘<懦<糯"
        + "<噢<哦<讴<欧<殴<瓯<鸥<呕<偶<耦<藕 <怄<沤"
        + "<趴<啪<葩<杷<爬<耙<琶 <筢<帕<怕<拍<俳<徘<排<牌<哌<派<湃<蒎< 潘<攀<爿<盘<磐<蹒<蟠<判<泮<叛<盼<畔<袢 <襻<乓<滂<庞<逄<旁<螃<耪<胖<抛<脬<刨< 咆<庖<狍<炮<袍<匏<跑<泡<疱<呸<胚<醅<陪 <培<赔<锫<裴<沛<佩<帔<旆<配<辔<霈<喷< 盆<湓<怦<抨<砰<烹<嘭<朋<堋<彭<棚<硼<蓬 <鹏<澎<篷<膨<蟛<捧<碰<丕<批<纰<邳<坯< 披<砒<铍<劈<噼<霹<皮<芘<枇<毗<疲<蚍<郫 <陴<啤<埤<琵<脾<罴<蜱<貔<鼙<匹<庀<仳< 圮<痞<擗<癖<屁<淠<媲<睥<僻<甓<譬<片<偏 <犏<篇<翩<骈<胼<蹁<谝<骗<剽<漂<缥<飘< 螵<瓢<殍<瞟<票<嘌<嫖<氕<撇<瞥<丿<苤<姘 <拼<贫<嫔<频<颦<品<榀<牝<娉<聘<乒<俜< 平<评<凭<坪<苹<屏<枰<瓶<萍<鲆<钋<坡<泼 <颇<婆<鄱<皤<叵<钷<笸<迫<珀<破<粕<魄< 剖<掊<裒<仆<攴<攵<扑<铺<噗<匍<莆<菩<葡 <蒲<璞<濮<镤<朴<圃<埔<浦<普<溥<谱<氆< 镨<蹼<瀑<曝"
        + "<七<沏<妻<柒<凄< 栖<桤<戚<萋<期<欺<嘁<槭<漆<蹊<亓<祁<齐 <圻<岐<芪<其<奇<歧<祈<耆<脐<颀<崎<淇< 畦<萁<骐<骑<棋<琦<琪<祺<蛴<旗<綦<蜞<蕲 <鳍<麒<乞<企<屺<岂<芑<启<杞<起<绮<綮< 气<讫<汔<迄<弃<汽<泣<契<砌<荠<葺<碛<器 <憩<掐<葜<恰<洽<髂<千<仟<阡<扦<芊<迁< 佥<岍<钎<牵<悭<铅<谦<愆<签<骞<搴<褰<前 <荨<钤<虔<钱<钳<乾<掮<箝<潜<黔<凵<浅< 肷<慊<遣<谴<缱<欠<芡<茜<倩<堑<嵌<椠<歉 <呛<羌<戕<戗<枪<跄<腔<蜣<锖<锵<镪<强< 墙<嫱<蔷<樯<抢<羟<襁<炝<悄<硗<跷<劁<敲 <锹<橇<缲<乔<侨<荞<桥<谯<憔<鞒<樵<瞧< 巧<愀<俏<诮<峭<窍<翘<撬<鞘<切<茄<且<妾 <怯<窃<挈<惬<箧<锲<亲<侵<钦<衾<芩<芹< 秦<琴<禽<勤<嗪<溱<噙<擒<檎<螓<锓<寝<吣 <沁<揿<青<氢<轻<倾<卿<圊<清<蜻<鲭<情< 晴<氰<擎<檠<黥<苘<顷<请<謦<庆<箐<磬<罄 <跫<銎<邛<穷<穹<茕<筇<琼<蛩<丘<邱<秋< 蚯<楸<鳅<囚<犰<求<虬<泅<俅<酋<逑<球<赇 <巯<遒<裘<蝤<鼽<糗<区<曲<岖<诎<驱<屈< 祛<蛆<躯<蛐<趋<麴<黢<劬<朐<鸲<渠<蕖<磲 <璩<蘧<氍<癯<衢<蠼<取<娶<龋<去<阒<觑< 趣<悛<圈<全<权<诠<泉<荃<拳<辁<痊<铨<筌 <蜷<醛<鬈<颧<犭<犬<畎<绻<劝<券<炔<缺< 瘸<却<悫<雀<确<阕<阙<鹊<榷<逡<裙<群"
        + "<蚺<然<髯<燃<冉<苒<染<禳<瓤 <穰<嚷<壤<攘<让<荛<饶<桡<扰<娆<绕<惹< 热<人<亻<仁<壬<忍<荏<稔<刃<认<仞<任<纫 <妊<轫<韧<饪<衽<恁<葚<扔<仍<日<戎<肜< 狨<绒<茸<荣<容<嵘<溶<蓉<榕<熔<蝾<融<冗 <柔<揉<糅<蹂<鞣<肉<如<茹<铷<儒<嚅<孺< 濡<薷<襦<蠕<颥<汝<乳<辱<入<洳<溽<缛<蓐 <褥<阮<朊<软<蕤<蕊<芮<枘<蚋<锐<瑞<睿< 闰<润<若<偌<弱<箬"
        + "<仨<撒<洒< 卅<飒<脎<萨<塞<腮<噻<鳃<赛<三<叁<毵<伞 <散<糁<馓<桑<嗓<搡<磉<颡<丧<搔<骚<缫< 臊<鳋<扫<嫂<埽<瘙<色<涩<啬<铯<瑟<穑<森 <僧<杀<沙<纱<刹<砂<莎<铩<痧<裟<鲨<傻< 唼<啥<歃<煞<霎<筛<晒<山<彡<删<杉<芟<姗 <衫<钐<埏<珊<舢<跚<煽<潸<膻<闪<陕<讪< 汕<疝<苫<剡<扇<善<骟<鄯<缮<嬗<擅<膳<赡 <蟮<鳝<伤<殇<商<觞<墒<熵<裳<垧<晌<赏< 上<尚<绱<捎<梢<烧<稍<筲<艄<蛸<勺<芍<苕 <韶<少<劭<邵<绍<哨<潲<奢<猞<赊<畲<舌< 佘<蛇<舍<厍<设<社<射<涉<赦<慑<摄<滠<麝 <申<伸<身<呻<绅<诜<娠<砷<深<神<沈<审< 哂<矧<谂<婶<渖<肾<甚<胂<渗<慎<椹<蜃<升 <生<声<牲<胜<笙<甥<渑<绳<省<眚<圣<晟< 盛<剩<嵊<尸<失<师<虱<诗<施<狮<湿<蓍<酾 <鲺<十<饣<什<石<时<识<实<拾<炻<蚀<食< 埘<莳<鲥<史<矢<豕<使<始<驶<屎<士<氏<礻 <世<仕<市<示<式<事<侍<势<视<试<饰<室< 恃<拭<是<柿<贳<适<舐<轼<逝<铈<弑<谥<释 <嗜<筮<誓<噬<螫<收<手<扌<守<首<艏<寿< 受<狩<兽<售<授<绶<瘦<书<殳<抒<纾<叔<枢 <姝<倏<殊<梳<淑<菽<疏<舒<摅<毹<输<蔬< 秫<孰<赎<塾<熟<暑<黍<署<鼠<蜀<薯<曙<术 <戍<束<沭<述<树<竖<恕<庶<数<腧<墅<漱< 澍<刷<唰<耍<衰<摔<甩<帅<蟀<闩<拴<栓<涮 <双<霜<孀<爽<谁<氵<水<税<睡<吮<顺<舜< 瞬<说<妁<烁<朔<铄<硕<嗍<搠<蒴<嗽<槊<厶 <纟<丝<司<私<咝<思<鸶<斯<缌<蛳<厮<锶< 嘶<撕<澌<死<巳<四<寺<汜<伺<似<兕<姒<祀 <泗<饲<驷<俟<笥<耜<嗣<肆<忪<松<凇<崧< 淞<菘<嵩<怂<悚<耸<竦<讼<宋<诵<送<颂<嗖 <搜<溲<馊<飕<锼<艘<螋<叟<嗾<瞍<擞<薮< 苏<酥<稣<俗<夙<诉<肃<涑<素<速<宿<粟<谡 <嗉<塑<愫<溯<僳<蔌<觫<簌<狻<酸<蒜<算< 虽<荽<眭<睢<濉<绥<隋<随<髓<岁<祟<谇<遂 <碎<隧<燧<穗<邃<孙<狲<荪<飧<损<笋<隼< 榫<唆<娑<挲<桫<梭<睃<嗦<羧<蓑<缩<所<唢 <索<琐<锁"
        + "<他<它<趿<铊<塌<溻 <塔<獭<鳎<挞<闼<遢<榻<踏<蹋<骀<胎<台< 邰<抬<苔<炱<跆<鲐<薹<太<汰<态<肽<钛<泰 <酞<坍<贪<摊<滩<瘫<坛<昙<谈<郯<覃<痰< 锬<谭<潭<檀<忐<坦<袒<钽<毯<叹<炭<探<赕 <碳<汤<铴<羰<镗<饧<唐<堂<棠<塘<搪<溏< 瑭<樘<膛<糖<螗<螳<醣<帑<倘<淌<傥<耥<躺 <烫<趟<涛<绦<掏<滔<韬<饕<洮<逃<桃<陶< 啕<淘<萄<鼗<讨<套<忑<忒<特<铽<慝<疼<腾 <誊<滕<藤<剔<梯<锑<踢<绨<啼<提<缇<鹈< 题<蹄<醍<体<屉<剃<倜<悌<涕<逖<惕<替<裼 <嚏<天<添<田<恬<畋<甜<填<阗<忝<殄<腆< 舔<掭<佻<挑<祧<条<迢<笤<龆<蜩<髫<鲦<窕 <眺<粜<铫<跳<贴<萜<铁<帖<餮<厅<汀<听< 町<烃<廷<亭<庭<莛<停<婷<葶<蜓<霆<挺<梃 <铤<艇<通<嗵<仝<同<佟<彤<茼<桐<砼<铜< 童<酮<僮<潼<瞳<统<捅<桶<筒<恸<痛<偷<亠 <头<投<骰<透<凸<秃<突<图<徒<涂<荼<途< 屠<酴<土<吐<钍<兔<堍<菟<湍<团<抟<疃<彖 <推<颓<腿<退<煺<蜕<褪<吞<暾<屯<饨<豚< 臀<氽<乇<托<拖<脱<驮<佗<陀<坨<沱<驼<柁 <砣<鸵<跎<酡<橐<鼍<妥<庹<椭<拓<柝<唾< 箨"
        + "<哇<娃<挖<洼<娲<蛙<瓦<佤< 袜<腽<歪<崴<外<弯<剜<湾<蜿<豌<丸<纨<芄 <完<玩<顽<烷<宛<挽<晚<莞<婉<惋<绾<脘< 菀<琬<皖<畹<碗<万<腕<汪<亡<王<网<往<枉 <罔<惘<辋<魍<妄<忘<旺<望<危<威<偎<逶< 隈<葳<微<煨<薇<巍<囗<为<韦<圩<围<帏<沩 <违<闱<桅<涠<唯<帷<惟<维<嵬<潍<伟<伪< 尾<纬<苇<委<炜<玮<洧<娓<诿<萎<隗<猥<痿 <艉<韪<鲔<卫<未<位<味<畏<胃<軎<尉<谓< 喂<渭<猬<蔚<慰<魏<温<瘟<文<纹<闻<蚊<阌 <雯<刎<吻<紊<稳<问<汶<璺<翁<嗡<蓊<瓮< 蕹<挝<倭<涡<莴<喔<窝<蜗<我<沃<肟<卧<幄 <握<渥<硪<斡<龌<乌<圬<污<邬<呜<巫<屋< 诬<钨<无<毋<吴<吾<芜<唔<梧<浯<蜈<鼯<五 <午<仵<伍<坞<妩<庑<忤<怃<迕<武<侮<捂< 牾<鹉<舞<兀<勿<务<戊<阢<杌<芴<物<误<悟 <晤<焐<婺<痦<骛<雾<寤<鹜<鋈"
        + "<夕<兮<汐<西<吸<希<昔<析<矽<穸<诶<郗 <唏<奚<息<浠<牺<悉<惜<欷<淅<烯<硒<菥< 晰<犀<稀<粞<翕<舾<溪<皙<锡<僖<熄<熙<蜥 <嘻<嬉<膝<樨<歙<熹<羲<螅<蟋<醯<曦<鼷< 习<席<袭<觋<媳<隰<檄<洗<玺<徙<铣<喜<葸 <屣<蓰<禧<戏<系<饩<细<郄<阋<舄<隙<禊< 呷<虾<瞎<匣<侠<狎<峡<柙<狭<硖<遐<暇<瑕 <辖<霞<黠<下<吓<夏<厦<罅<仙<先<纤<氙< 祆<籼<莶<掀<跹<酰<锨<鲜<暹<闲<弦<贤<咸 <涎<娴<舷<衔<痫<鹇<嫌<冼<显<险<猃<蚬< 筅<跣<藓<燹<县<岘<苋<现<线<限<宪<陷<馅 <羡<献<腺<霰<乡<芗<相<香<厢<湘<缃<葙< 箱<襄<骧<镶<详<庠<祥<翔<享<响<饷<飨<想 <鲞<向<巷<项<象<像<橡<蟓<枭<削<哓<枵< 骁<宵<消<绡<逍<萧<硝<销<潇<箫<霄<魈<嚣 <崤<淆<小<晓<筱<孝<肖<哮<效<校<笑<啸< 些<楔<歇<蝎<协<邪<胁<挟<偕<斜<谐<携<勰 <撷<缬<鞋<写<泄<泻<绁<卸<屑<械<亵<渫< 谢<榍<榭<廨<懈<獬<薤<邂<燮<瀣<蟹<躞<忄 <心<忻<芯<辛<昕<欣<莘<锌<新<歆<薪<馨< 鑫<囟<信<衅<兴<星<惺<猩<腥<刑<行<邢<形 <陉<型<硎<醒<擤<杏<姓<幸<性<荇<悻<凶< 兄<匈<芎<汹<胸<雄<熊<休<修<咻<庥<羞<鸺 <貅<馐<髹<朽<秀<岫<绣<袖<锈<溴<戌<盱< 砉<胥<须<顼<虚<嘘<需<墟<徐<许<诩<栩<糈 <醑<旭<序<叙<恤<洫<畜<勖<绪<续<酗<婿< 溆<絮<嗅<煦<蓄<蓿<轩<宣<谖<喧<揎<萱<暄 <煊<儇<玄<痃<悬<旋<漩<璇<选<癣<泫<炫< 绚<眩<铉<渲<楦<碹<镟<靴<薛<穴<学<泶<踅 <雪<鳕<血<谑<勋<埙<熏<窨<獯<薰<曛<醺< 寻<巡<旬<驯<询<峋<恂<洵<浔<荀<循<鲟<训 <讯<汛<迅<徇<逊<殉<巽<蕈"
        + "<丫 <压<呀<押<鸦<桠<鸭<牙<伢<岈<芽<琊<蚜< 崖<涯<睚<衙<疋<哑<痖<雅<亚<讶<迓<垭<娅 <砑<氩<揠<咽<恹<烟<胭<崦<淹<焉<菸<阉< 湮<腌<鄢<嫣<蔫<讠<延<闫<严<妍<芫<言<岩 <沿<炎<研<盐<阎<筵<蜒<颜<檐<兖<奄<俨< 衍<偃<厣<掩<眼<郾<琰<罨<演<魇<鼹<厌<彦 <砚<唁<宴<晏<艳<验<谚<堰<焰<焱<雁<滟< 酽<谳<餍<燕<赝<央<泱<殃<秧<鸯<鞅<扬<羊 <阳<杨<炀<佯<疡<徉<洋<烊<蛘<仰<养<氧< 痒<怏<恙<样<漾<幺<夭<吆<妖<腰<邀<爻<尧 <肴<姚<轺<珧<窑<谣<徭<摇<遥<瑶<繇<鳐< 杳<咬<窈<舀<崾<药<要<鹞<曜<耀<椰<噎<爷 <耶<揶<铘<也<冶<野<业<叶<曳<页<邺<夜< 晔<烨<掖<液<谒<腋<靥<一<衤<伊<衣<医<依 <咿<猗<铱<壹<揖<欹<漪<噫<黟<仪<圯<夷< 沂<诒<宜<怡<迤<饴<咦<姨<荑<贻<眙<胰<酏 <痍<移<遗<颐<疑<嶷<彝<乙<已<以<钇<矣< 苡<舣<蚁<倚<椅<旖<义<亿<弋<刈<忆<艺<仡 <议<亦<屹<异<佚<呓<役<抑<译<邑<佾<峄< 怿<易<绎<诣<驿<奕<弈<疫<羿<轶<悒<挹<益 <谊<埸<翊<翌<逸<意<溢<缢<肄<裔<瘗<蜴< 毅<熠<镒<劓<殪<薏<翳<翼<臆<癔<镱<懿<因 <阴<姻<洇<茵<荫<音<殷<氤<铟<喑<堙<吟< 垠<狺<寅<淫<银<鄞<夤<龈<霪<廴<尹<引<吲 <饮<蚓<隐<瘾<印<茚<胤<应<英<莺<婴<瑛< 嘤<撄<缨<罂<樱<璎<鹦<膺<鹰<迎<茔<盈<荥 <荧<莹<萤<营<萦<楹<滢<蓥<潆<蝇<嬴<赢< 瀛<郢<颍<颖<影<瘿<映<硬<媵<哟<唷<佣<拥 <痈<邕<庸<雍<墉<慵<壅<镛<臃<鳙<饔<喁< 永<甬<咏<泳<俑<勇<涌<恿<蛹<踊<用<优<忧 <攸<呦<幽<悠<尢<尤<由<犹<邮<油<柚<疣< 莜<莸<铀<蚰<游<鱿<猷<蝣<友<有<卣<酉<莠 <铕<牖<黝<又<右<幼<佑<侑<囿<宥<诱<蚴< 釉<鼬<纡<迂<淤<渝<瘀<于<予<余<妤<欤<於 <盂<臾<鱼<俞<禺<竽<舁<娱<狳<谀<馀<渔< 萸<隅<雩<嵛<愉<揄<腴<逾<愚<榆<瑜<虞<觎 <窬<舆<蝓<与<伛<宇<屿<羽<雨<俣<禹<语< 圄<圉<庾<瘐<窳<龉<玉<驭<吁<聿<芋<妪<饫 <育<郁<昱<狱<峪<浴<钰<预<域<欲<谕<阈< 喻<寓<御<裕<遇<鹆<愈<煜<蓣<誉<毓<蜮<豫 <燠<鹬<鬻<鸢<冤<眢<鸳<渊<箢<元<员<园< 沅<垣<爰<原<圆<袁<援<缘<鼋<塬<源<猿<辕 <圜<橼<螈<远<苑<怨<院<垸<媛<掾<瑗<愿< 曰<约<月<刖<岳<钥<悦<钺<阅<跃<粤<越<樾 <龠<瀹<云<匀<纭<芸<昀<郧<耘<氲<允<狁< 陨<殒<孕<运<郓<恽<晕<酝<愠<韫<韵<熨<蕴"
        + "<匝<咂<拶<杂<砸<灾<甾<哉<栽 <宰<载<崽<再<在<糌<簪<咱<昝<攒<趱<暂< 赞<錾<瓒<赃<臧<驵<奘<脏<葬<遭<糟<凿<早 <枣<蚤<澡<藻<灶<皂<唣<造<噪<燥<躁<则< 择<泽<责<迮<啧<帻<笮<舴<箦<赜<仄<昃<贼 <怎<谮<曾<增<憎<缯<罾<锃<甑<赠<吒<咋< 哳<喳<揸<渣<楂<齄<扎<札<轧<闸<铡<眨<砟 <乍<诈<咤<栅<炸<痄<蚱<榨<膪<斋<摘<宅< 翟<窄<债<砦<寨<瘵<沾<毡<旃<粘<詹<谵<澶 <瞻<斩<展<盏<崭<搌<辗<占<战<栈<站<绽< 湛<骣<蘸<张<章<鄣<嫜<彰<漳<獐<樟<璋<蟑 <仉<涨<掌<丈<仗<帐<杖<胀<账<障<嶂<幛< 瘴<钊<招<昭<啁<找<沼<召<兆<诏<赵<笊<棹 <照<罩<肇<蜇<遮<折<哲<辄<蛰<谪<摺<磔< 辙<者<锗<赭<褶<这<柘<浙<蔗<鹧<贞<针<侦 <浈<珍<桢<真<砧<祯<斟<甄<蓁<榛<箴<臻< 诊<枕<胗<轸<畛<疹<缜<稹<圳<阵<鸩<振<朕 <赈<镇<震<争<征<怔<峥<挣<狰<钲<睁<铮< 筝<蒸<徵<拯<整<正<证<诤<郑<帧<政<症<之 <支<卮<汁<芝<吱<枝<知<织<肢<栀<祗<胝< 脂<蜘<执<侄<直<值<埴<职<植<殖<絷<跖<摭 <踯<夂<止<只<旨<址<纸<芷<祉<咫<指<枳< 轵<趾<黹<酯<至<志<忮<豸<制<帙<帜<治<炙 <质<郅<峙<栉<陟<挚<桎<秩<致<贽<轾<掷< 痔<窒<鸷<彘<智<滞<痣<蛭<骘<稚<置<雉<膣 <觯<踬<中<忠<终<盅<钟<舯<衷<锺<螽<肿< 种<冢<踵<仲<众<重<州<舟<诌<周<洲<粥<妯 <轴<碡<肘<帚<纣<咒<宙<绉<昼<胄<荮<皱< 酎<骤<籀<朱<侏<诛<邾<洙<茱<株<珠<诸<猪 <铢<蛛<槠<潴<橥<竹<竺<烛<逐<舳<瘃<躅< 丶<主<拄<渚<属<煮<嘱<麈<瞩<伫<住<助<苎 <杼<注<贮<驻<柱<炷<祝<疰<著<蛀<筑<铸< 箸<翥<抓<爪<拽<专<砖<颛<转<啭<赚<撰<篆 <馔<妆<庄<桩<装<丬<壮<状<幢<撞<隹<追< 骓<椎<锥<坠<缀<惴<缒<赘<肫<窀<谆<准<卓 <拙<倬<捉<桌<涿<灼<茁<斫<浊<浞<诼<酌< 啄<着<琢<禚<擢<濯<镯<仔<孜<兹<咨<姿<赀 <资<淄<缁<谘<孳<嵫<滋<粢<辎<觜<趑<锱< 龇<髭<鲻<籽<子<姊<秭<耔<笫<梓<紫<滓<訾 <字<自<恣<渍<眦<宗<综<棕<腙<踪<鬃<总< 偬<纵<粽<邹<驺<诹<陬<鄹<鲰<走<奏<揍<租 <菹<足<卒<族<镞<诅<阻<组<俎<祖<躜<缵< 纂<钻<攥<嘴<最<罪<蕞<醉<尊<遵<樽<鳟<撙 <昨<左<佐<作<坐<阼<怍<柞<祚<胙<唑<座< 做";

    /**
     * 构造函数
     */
    public IreadCollator()
    {
    }

    /**
     * 构造函数
     * 
     * @param str
     *            String 起始字符串
     */
    public IreadCollator(String str)
    {
        baseString = str;
    }

    /**
     * 将入参与起始字符串按拼音顺序进行比较
     * 
     * @author mWX177641
     * @param o
     *            Object 进行比较的字符串
     * @return int 小于起始字符串，返回负数；等于起始字符串，返回0；大于起始字符串，返回 正数
     */
    public int compareTo(Object o)
    {
        return GB2312Collator.compare(o, baseString);
    }

    /**
     * 判断入参是否等于起始字符串
     * 
     * @author mWX177641
     * @param obj
     *            Object 进行比较的字符串
     * @return boolean true 等于；false 不等于
     */
    public boolean equals(Object obj)
    {
        return baseString.equals(obj.toString());
    }

    /**
     * 比较两个参数中文字符串按拼音排序的顺序
     * 
     * @author mWX177641
     * @param o1
     *            Object 入参1
     * @param o2
     *            Object 入参2
     * @return int 入参1<入参2 返回负数；入参1=入参2 返回0；入参1>入参2 返回正数
     */
    public int compare(Object o1, Object o2)
    {
        return GB2312Collator.compare(o2, o1);
    }

    /**
     * 该方法不实现逻辑
     * 
     * @author mWX177641
     * @param obj
     *            Object[]
     */
    public static void compare(Object[] obj)
    {

    }

    /**
     * 构造比较器
     * 
     * @return RuleBasedCollator 比较器
     */
    public static RuleBasedCollator getGB2312Collator()
    {
        // 原始排序规则
        String rules = ((RuleBasedCollator) Collator.getInstance(Locale.CHINA)).getRules();

        // 去第一个中文位置,用新的中文规则替换
        int index = rules.indexOf("啊");

        // 加入新的中文排序规则的排序
        String chineseRules = rules.substring(0, index) + GB2312Chars;

        // 设置排序容器
        RuleBasedCollator collator = getFixedGB2312Collator(chineseRules);

        // 如果用新的排序规则比较失败, 则构造原来的规则
        if (null == collator)
        {
            collator = getFixedGB2312Collator(rules);
        }

        return collator;
    }

    /**
     * 根据入参规则生成比较器
     * 
     * @author mWX177641
     * @param rules
     *            String 规则
     * @return RuleBasedCollator 比较器
     */
    private static final RuleBasedCollator getFixedGB2312Collator(String rules)
    {
        RuleBasedCollator fixedGB2312Collator = null;
        try
        {
            fixedGB2312Collator = new RuleBasedCollator(rules);
        }
        catch (ParseException e)
        {
        }

        return fixedGB2312Collator;
    }

}