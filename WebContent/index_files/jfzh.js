//δ�����ɣ����öԴ˳�����д۸Ļ�Ϯ������ת�أ�����ϵ����!//shopxp.cn
var Default_isFT = 0		//Ĭ���Ƿ��壬0-���壬1-����//shopxp.cn
var StranIt_Delay = 50 //������ʱ���루�������Ŀ��������ҳ�����������ֳ�����

//�����������������뿪ʼ�����±�ģ�������������
//ת���ı�//shopxp.cn
function StranText(txt,toFT,chgTxt)
{
	if(txt==""||txt==null)return ""
	toFT=toFT==null?BodyIsFt:toFT
	if(chgTxt)txt=txt.replace((toFT?"��":"��"),(toFT?"��":"��"))
	if(toFT){return Traditionalized(txt)}
	else {return Simplized(txt)}
}
//ת������ʹ�õݹ飬�������ı�//shopxp.cn
function StranBody(fobj)
{
	if(typeof(fobj)=="object"){var obj=fobj.childNodes}
	else 
	{
		var tmptxt=StranLink_Obj.innerHTML.toString()
		if(tmptxt.indexOf("��")<0)
		{
			BodyIsFt=1
			StranLink_Obj.innerHTML=StranText(tmptxt,0,1)
			StranLink.title=StranText(StranLink.title,0,1)
		}
		else
		{
			BodyIsFt=0
			StranLink_Obj.innerHTML=StranText(tmptxt,1,1)
			StranLink.title=StranText(StranLink.title,1,1)
		}
		setCookie(JF_cn,BodyIsFt,7)
		var obj=document.body.childNodes
	}
	for(var i=0;i<obj.length;i++)
	{
		var OO=obj.item(i)
		if("||BR|HR|TEXTAREA|".indexOf("|"+OO.tagName+"|")>0||OO==StranLink_Obj)continue;
		if(OO.title!=""&&OO.title!=null)OO.title=StranText(OO.title);
		if(OO.alt!=""&&OO.alt!=null)OO.alt=StranText(OO.alt);
		if(OO.tagName=="INPUT"&&OO.value!=""&&OO.type!="text"&&OO.type!="hidden")OO.value=StranText(OO.value);
		if(OO.nodeType==3){OO.data=StranText(OO.data)}
		else StranBody(OO)
	}
}
function JTPYStr()
{
	return '�������������°Ӱհڰܰ����������������������������������ʱϱбձ߱�����������������������������βϲвѲҲӲԲղֲײ޲����������������������������������������������³ĳųƳͳϳҳճٳ۳ܳݳ�������������������������������������´ǴʴʹϴдѴӴԴմܴ�������������������������������������������Ƶ˵еӵݵ޵���������������������������������������ĶƶͶ϶жҶӶԶֶٶ۶�����������������������������������÷ķɷϷѷ׷طܷ߷�������������������������������øƸǸɸϸѸӸԸոָٸڸ޸����������������������������ƹ˹йع۹ݹ߹�����������������������������Һ׺غ���������������������������������������������ƻѻӻԻٻ߻���������������������������������������������üƼǼʼ̼ͼмԼռּؼۼݼ߼����������������������������������������������������������������½ýĽŽȽɽʽνϽս׽ھ����������������������ǾɾԾپݾ�����ܽ������������������������������������������ſǿοѿҿٿ���������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������¢£¤¥¦§¨«¬­®¯°±²³¸»¼½¿����������������������������������������������������������������������������������������áèêíóôùûþ����������������������������������ıĶ����������������������������������������šŢťŦŧŨũűŵŷŸŹŻŽ���ӹ���������ƭƮƵƶƻƾ������������������������������ǣǤǥǦǨǩǫǮǯǱǳǴǵǹǺǽǾǿ��������������������������������������������ȣȧȨȰȴȵ������������������������������������ɡɥɧɨɬɱɴɸɹ��������������������������������������ʤʥʦʨʪʫʬʱʴʵʶʻ��������������������������������˧˫˭˰˳˵˶˸˿��������������������������������������̷̸̡̢̧̯̰̱̲̳̾��������������������������������ͭͳͷͼͿ������������������������������ΤΥΧΪΫάέΰαγν������������������������������������������������ϮϰϳϷϸϺϽϿ��������������������������������������������������������ХЫЭЮЯвгдклп��������������������������ѡѢѤѧѫѯѰѱѵѶѷѹѻѼ������������������������������������������������ҡҢңҤҥҩүҳҵҶҽҿ��������������������������������������ӣӤӥӦӧӨөӪӫӬӱӴӵӶӸӻӽӿ������������������������������������ԤԦԧԨԯ԰ԱԲԵԶԸԼԾԿ������������������������������������������������������������������աբթիծձյնշոջս����������������������������������������ְִֽֿ֣֤֡֯��������������������������������������������פרשת׬׮ׯװױ׳״׶׸׹׺׻����������������������������ôΪֻ��׼������������й';
}
function FTPYStr()
{
	return '�}�@�K���O�\�W���T�[���C�k�O�ͽ��^�r������U݅ؐ�^�N��v���P�����]߅���H׃�q�p���T�l�I�e�P����K�g�N�a���Q���M�K�N�nœ�}����ȃԜy��Ԍ�v���s�׋�p�P�b�U��L�L���c�S���n܇�؉m��r�ηQ���\�G�V�t�Y�u�X��_�x�����P�I�I�h���N�z�r�A���|̎�����J���N���b�o�~�n�[��ą����Z�e�_���J��������đ���Q�������hʎ�n�v�u�\���I���������f���c�|늝���{��ՙ�B���Vӆ�|�ӗ����Y�٪��xـ�呔྄��ꠌ����D�g�Z�Z�~Ӟ���I�����D�E�l�P�y�m�\�C����؜��L���w�U�M�����^���S�S���h�L���T�p�S�P�wݗ���o�x�}ؓӇ�D�`ԓ�}�w���s���M����䓾V���V怔R���w�t���o���m�ؕ�h�Ϙ�ُ���M��P�^�^�T؞�VҎ���w���|܉Ԏ���F��݁�L假��^��n�h�u�Q�R�M�Z���t����o����W�A����Ԓ�щĚg�h߀���Q�������o�S�e�]�x���V�x���Z���M�d�Lȝ��ⷫ@؛�����C�e���I�u�����O݋���D���E����Ӌӛ�H�^�o�A�v�a�Z⛃r�{���O�Թ{�g�D�}�O�z�A�|���캆���p�]���b�`�vҊ�IŞ���T�u�R���{�Y�����v�u�z���ɔ��q�C�e�_��U�g�I�^�M�A���o�@���i�o�R���d���Q�m���f�x�e��䏑ք��N���ܝ��Y�]�þo�\�H֔�M�x�a�M���G�X�Q�E�^�x܊�E�_�P�w���n��������ѝ�F�K�~���V��r̝�h�Q�����U�Ϟ�D�R��ه�{�ڔr�@�@�m��׎���[���|���E�Ƅڝ����D��I�h�x�Y���Y������[�ўr�`�zɏ�B砑z�i����Ę朑ٟ����Z�����vՏ���|炫C�R���[�C�U�g⏜R�`�X�I�s�����@���\�Ŕn�]�Ǌ䓧�t�J�R�B�]�t���u̔���T�����H���X�H�ҿ|�]�V�G�n���\���y��݆�����S�]Փ�}�_߉茻j��j�����aΛ�R�R���I���u�~�}�m�z�U�M֙؈�^�T�Q���q�]�V�T�����i���i��Ғ�d���R�瑑�}�Q�և�\���c�{�y���X���[�Hā�f����B�m�懙���帔Q���o�~ē���r���Z�W�t���I�a�P�������r���i�_�h�lؚ�O�{�u���H��䁘��VĚ�R�T�M���◉ә���L�T�U�w���t�X�Q���\�l�q���ܠ��N�����@��̃S�N�[�`�J�H�p��A�Ո�c���Fڅ�^�|��x�E����s�o׌���_�@���g�J�x�s�qܛ�J�c�����_�wِ����}�ߝ������Y���W�٠�����p���B�d�z���O�������I�B�K���}���{��Ԋ�ƕr�g���R����ҕԇ�۫F��ݔ���H���g���Q�����p�l����f�T�q�z��Z��A�b�\�K�V�C�m���q�O�p�S�s���i�H��E��؝�c�����TՄ�U���C���l�v�`�R�}�w�ϗl�N�F�d �N�~�y�^�D�T�F�j͑Ó�r�W�E�D�m�����B�f�W�f�`�����H�SȔ���^���^�l���y�����Y��΁�u�C���u���_�oʏ�ǉ]�F���`�a���u��㊑��rݠ�{�b�M�B�v�r�w�y�t��e�@�U�F�I�h�W�w��������lԔ��ʒ�N�ԇ[ϐ�f���y�{�C���a�x�\��d���n�C̓�u��S�w�m܎���x�_�k�W��ԃ���ZӖӍ�d���f������Ӡ鎟��}�����W�������V�����P��ꖰW�B�Ӭ��u���b�G�{ˎ��퓘I�~�t��U�z�x��ρˇ�|���xԄ�h�x�g���[�a��yы������t��Ξ�I��ω�f�ѓ��b�xԁ�����n�]♪q�[�Tݛ�~�O���c�Z�Z�n�R�z�u�A�S�x�Y�@�@�T�A���hs�S耎[�������y���E�\�N�j����s���d����ٝ�E�v菗��^؟��t���\ٛ����܈��l�p�S���ֱK��ݚ�䗣��`���q���~Û�w�U�H�N�@ؑᘂ��\�ꇒ걠�b�����C���̼����S���|�R�K�N�[�\�a�S�����E�i�T�D�T�����A�T�B�v���u�Dٍ���f�b�y�Ѡ��F٘���YՁ��Ɲ�Y�nۙ�C���v�u�{�M荿@��N���b���ʆ���e�Z�N倛�';
}
function Traditionalized(cc){
	var str='',ss=JTPYStr(),tt=FTPYStr();
	for(var i=0;i<cc.length;i++)
	{
		if(cc.charCodeAt(i)>10000&&ss.indexOf(cc.charAt(i))!=-1)str+=tt.charAt(ss.indexOf(cc.charAt(i)));
  		else str+=cc.charAt(i);
	}
	return str;
}
function Simplized(cc){
	var str='',ss=JTPYStr(),tt=FTPYStr();
	for(var i=0;i<cc.length;i++)
	{
		if(cc.charCodeAt(i)>10000&&tt.indexOf(cc.charAt(i))!=-1)str+=ss.charAt(tt.indexOf(cc.charAt(i)));
  		else str+=cc.charAt(i);
	}
	return str;
}

function setCookie(name, value)		//cookies����//shopxp.cn
{
	var argv = setCookie.arguments;
	var argc = setCookie.arguments.length;
	var expires = (argc > 2) ? argv[2] : null;
	if(expires!=null)
	{
		var LargeExpDate = new Date ();
		LargeExpDate.setTime(LargeExpDate.getTime() + (expires*1000*3600*24));
	}
	document.cookie = name + "=" + escape (value)+((expires == null) ? "" : ("; expires=" +LargeExpDate.toGMTString()));
}

function getCookie(Name)			//cookies��ȡ//shopxp.cn
{
	var search = Name + "="
	if(document.cookie.length > 0) 
	{
		offset = document.cookie.indexOf(search)
		if(offset != -1) 
		{
			offset += search.length
			end = document.cookie.indexOf(";", offset)
			if(end == -1) end = document.cookie.length
			return unescape(document.cookie.substring(offset, end))
		 }
	else return ""
	  }
}

var StranLink_Obj=document.getElementById("StranLink")
if (StranLink_Obj)
{
	var JF_cn="ft"+self.location.hostname.toString().replace(/\./g,"")
	var BodyIsFt=getCookie(JF_cn)
	if(BodyIsFt!="1")BodyIsFt=Default_isFT
	with(StranLink_Obj)
	{
		if(typeof(document.all)!="object") 	//��IE�����//shopxp.cn
		{
			href="javascript:StranBody()"
		}
		else
		{
			href="#";
			onclick= new Function("StranBody();return false")
		}
		title=StranText("����Է������ķ�ʽ���",1,1)
		innerHTML=StranText(innerHTML,1,1)
	}
	if(BodyIsFt=="1"){setTimeout("StranBody()",StranIt_Delay)}
}