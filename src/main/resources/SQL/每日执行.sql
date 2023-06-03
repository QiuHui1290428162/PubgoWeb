<!--删除调入单-->

update delivery SET flag = '0'  where deliveryid in(
	select deliveryid from ShopTin where Posted = '0' 
)
update shoptout SET flag = '0' where shoptoutid in(
	select shoptoutid from ShopTin where Posted = '0' 
)
delete from ShopTinDetail where ShopTinGoodsID in(
	Select ShopTinGoodsID from ShopTinGoods,ShopTin where ShopTinGoods.ShopTinID = ShopTin.ShopTinID And ShopTin.Posted = '0'
)
delete from ShopTinGoods where ShopTinID in ( 
	select ShopTinID from ShopTin where Posted = '0' 
)
delete from ShopTin where Posted = '0'

<!--会员生日修改折扣等级-->

use bbgdata

UPDATE CustomerVip SET CustomerVip.VipGrade= CustomerVip.tel 
WHERE VipGrade='2';

UPDATE CustomerVip SET CustomerVip.tel=CustomerVip.VipGrade, VipGrade='2' 
	WHERE  DATEPART(MM,BirthDate) = DATEPART(MM,GETDATE()) 
	AND DATEPART(DD,BirthDate) = DATEPART(DD,GETDATE())
	AND Customer_ID NOT IN ('GD077','GD078');

UPDATE CustomerVip SET VipGrade='2'  
	WHERE Customer_ID IN ('GD077','GD078')
	AND DATEPART(MM,BirthDate) = DATEPART(MM,GETDATE()) 
	AND DATEPART(DD,BirthDate) <= DATEPART(DD,GETDATE())+3
	AND DATEPART(DD,BirthDate) >= DATEPART(DD,GETDATE())-3;
	
	
	
	
	
	