-- ----------------------------
-- Table structure for mtime_brand_dict_t
-- ----------------------------
DROP TABLE IF EXISTS `mtime_brand_dict_t`;
CREATE TABLE mtime_brand_dict_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  show_name VARCHAR(100) COMMENT '显示名称'
) COMMENT '品牌信息表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mtime_brand_dict_t
-- ----------------------------
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(99,'全部');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(1,'大地影院');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(2,'万达影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(3,'耀莱成龙国际影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(4,'保利国际影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(5,'博纳国际影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(6,'金逸影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(7,'中影国际影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(8,'CGV影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(9,'橙天嘉禾影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(10,'新华国际影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(11,'星美国际影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(12,'百老汇影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(13,'UME国际影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(14,'幸福蓝海国际影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(15,'首都电影院');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(16,'华谊兄弟影院');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(17,'卢米埃影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(18,'沃美影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(19,'美嘉欢乐影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(20,'嘉华国际影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(21,'17.5影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(22,'太平洋电影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(23,'SFC上影影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(24,'嘉美国际影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(25,'东都影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(26,'鲁信影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(27,'华影国际影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(28,'搜秀影城');
INSERT INTO mtime_brand_dict_t(UUID,show_name) VALUES(29,'横店电影城');



-- ----------------------------
-- Table structure for mtime_area_dict_t
-- ----------------------------
DROP TABLE IF EXISTS `mtime_area_dict_t`;
CREATE TABLE mtime_area_dict_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  show_name VARCHAR(100) COMMENT '显示名称'
) COMMENT '地域信息表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mtime_area_dict_t
-- ----------------------------
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(99,'全部');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(1,'朝阳区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(2,'海淀区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(3,'丰台区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(4,'大兴区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(5,'东城区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(6,'西城区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(7,'通州区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(8,'房山区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(9,'昌平区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(10,'顺义区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(11,'怀柔区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(12,'门头沟');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(13,'石景山区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(14,'密云区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(15,'平谷区');
INSERT INTO mtime_area_dict_t(UUID,show_name) VALUES(16,'延庆区');


-- ----------------------------
-- Table structure for mtime_hall_dict_t
-- ----------------------------
DROP TABLE IF EXISTS `mtime_hall_dict_t`;
CREATE TABLE mtime_hall_dict_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  show_name VARCHAR(100) COMMENT '显示名称',
  seat_address VARCHAR(200) COMMENT '座位文件存放地址'
) COMMENT '地域信息表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mtime_hall_dict_t
-- ----------------------------
INSERT INTO mtime_hall_dict_t(UUID,show_name) VALUES(99,'全部');
INSERT INTO mtime_hall_dict_t(UUID,show_name,seat_address) VALUES(1,'IMAX厅','seats/123214.json');
INSERT INTO mtime_hall_dict_t(UUID,show_name,seat_address) VALUES(2,'CGS中国巨幕厅','seats/123214.json');
INSERT INTO mtime_hall_dict_t(UUID,show_name,seat_address) VALUES(3,'杜比全景声厅','seats/123214.json');
INSERT INTO mtime_hall_dict_t(UUID,show_name,seat_address) VALUES(4,'Dolby Cinema厅','seats/123214.json');
INSERT INTO mtime_hall_dict_t(UUID,show_name,seat_address) VALUES(5,'RealD厅','seats/123214.json');
INSERT INTO mtime_hall_dict_t(UUID,show_name,seat_address) VALUES(6,'RealD 6FL厅','seats/123214.json');
INSERT INTO mtime_hall_dict_t(UUID,show_name,seat_address) VALUES(7,'LUXE巨幕厅','seats/123214.json');
INSERT INTO mtime_hall_dict_t(UUID,show_name,seat_address) VALUES(8,'4DX厅','seats/123214.json');
INSERT INTO mtime_hall_dict_t(UUID,show_name,seat_address) VALUES(9,'DTS:X 临境音厅','seats/123214.json');
INSERT INTO mtime_hall_dict_t(UUID,show_name,seat_address) VALUES(10,'儿童厅','seats/123214.json');
INSERT INTO mtime_hall_dict_t(UUID,show_name,seat_address) VALUES(11,'4K厅','seats/123214.json');
INSERT INTO mtime_hall_dict_t(UUID,show_name,seat_address) VALUES(12,'4D厅','seats/123214.json');
INSERT INTO mtime_hall_dict_t(UUID,show_name,seat_address) VALUES(13,'巨幕厅','seats/123214.json');



-- ----------------------------
-- Table structure for mtime_cinema_t
-- ----------------------------
DROP TABLE IF EXISTS `mtime_cinema_t`;
CREATE TABLE mtime_cinema_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  cinema_name VARCHAR(50) COMMENT '影院名称',
  cinema_phone VARCHAR(50) COMMENT '影院电话',
  brand_id INT COMMENT '品牌编号',  
  area_id INT COMMENT '地域编号',
  hall_ids VARCHAR(200) COMMENT '包含的影厅类型,以#作为分割',
  img_address VARCHAR(500) COMMENT '影院图片地址',
  cinema_address VARCHAR(200) COMMENT '影院地址',
  minimum_price INT DEFAULT 0 COMMENT '最低票价'
) COMMENT '影院信息表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mtime_cinema_t
-- ----------------------------
INSERT INTO mtime_cinema_t(UUID,cinema_name,brand_id,area_id,cinema_address,minimum_price,img_address,cinema_phone,hall_ids)
	VALUES(1,'大地影院(顺义店)',1,1,"北京市顺义区华联金街购物中心",60,'/cinemas/30445282__5675168.jpg','18500003333','#1#3#5#6#');
INSERT INTO mtime_cinema_t(UUID,cinema_name,brand_id,area_id,cinema_address,minimum_price,img_address,cinema_phone,hall_ids)
	VALUES(2,'大地影院(中关村店)',1,2,"北京市中关村海龙大厦",60,'/cinemas/30445282__5675168.jpg','010-58391939','#1#2#3#4#');
INSERT INTO mtime_cinema_t(UUID,cinema_name,brand_id,area_id,cinema_address,minimum_price,img_address,cinema_phone,hall_ids)
	VALUES(3,'万达影院(大屯店)',2,3,"北京市朝阳区大屯路50号金街商场",60,'/cinemas/44374823__5777386.jpg','010-58391939','#5#6#7#8#');
INSERT INTO mtime_cinema_t(UUID,cinema_name,brand_id,area_id,cinema_address,minimum_price,img_address,cinema_phone,hall_ids)
	VALUES(4,'万达影院(奥体中心店)',2,4,"北京市朝阳区奥林匹克公园新奥购物中心",60,'/cinemas/44374823__5777386.jpg','010-58391231','#1#3#5#6#');
INSERT INTO mtime_cinema_t(UUID,cinema_name,brand_id,area_id,cinema_address,minimum_price,img_address,cinema_phone,hall_ids)
	VALUES(5,'万达影院(中南海店)',2,5,"北京市东城区中南海52号",60,'/cinemas/44374823__5777386.jpg','010-58398521','#1#5#7#8#');
INSERT INTO mtime_cinema_t(UUID,cinema_name,brand_id,area_id,cinema_address,minimum_price,img_address,cinema_phone,hall_ids)
	VALUES(6,'万达影院(国贸店)',2,6,"北京市朝阳区国贸CBD核心商场5012",60,'/cinemas/5_0805163047.jpg','010-96385274','#1#2#3#7#');
INSERT INTO mtime_cinema_t(UUID,cinema_name,brand_id,area_id,cinema_address,minimum_price,img_address,cinema_phone,hall_ids)
	VALUES(7,'慕课影院(大屯店)',3,7,"北京市朝阳区大屯路50号金街商场",60,'/cinemas/5_0805163047.jpg','010-98765432','#1#5#8#9#');


-- ----------------------------
-- Table structure for mtime_field_t
-- ----------------------------
DROP TABLE IF EXISTS `mtime_field_t`;
CREATE TABLE mtime_field_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  cinema_id INT COMMENT '影院编号',
  film_id INT COMMENT '电影编号',
  begin_time VARCHAR(50) COMMENT '开始时间',
  end_time VARCHAR(50) COMMENT '结束时间',  
  hall_id INT COMMENT '放映厅类型编号',
  hall_name VARCHAR(200) COMMENT '放映厅名称',
  price INT COMMENT '票价'
) COMMENT '放映场次表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mtime_field_t
-- ----------------------------
INSERT INTO mtime_field_t(UUID,cinema_id,film_id,begin_time,end_time,hall_id,hall_name,price)
	VALUES(1,1,2,'09:50','11:20',1,'一号厅',60);
INSERT INTO mtime_field_t(UUID,cinema_id,film_id,begin_time,end_time,hall_id,hall_name,price)
	VALUES(2,1,3,'11:50','13:20',2,'IMAX厅',60);
INSERT INTO mtime_field_t(UUID,cinema_id,film_id,begin_time,end_time,hall_id,hall_name,price)
	VALUES(3,1,3,'13:50','15:20',3,'飞翔体验厅',60);
INSERT INTO mtime_field_t(UUID,cinema_id,film_id,begin_time,end_time,hall_id,hall_name,price)
	VALUES(4,3,2,'11:50','13:20',3,'7号超大厅',60);
INSERT INTO mtime_field_t(UUID,cinema_id,film_id,begin_time,end_time,hall_id,hall_name,price)
	VALUES(5,3,2,'11:50','13:20',4,'飞翔体验厅',60);
INSERT INTO mtime_field_t(UUID,cinema_id,film_id,begin_time,end_time,hall_id,hall_name,price)
	VALUES(6,5,2,'11:50','13:20',5,'3号VIP厅',60);
INSERT INTO mtime_field_t(UUID,cinema_id,film_id,begin_time,end_time,hall_id,hall_name,price)
	VALUES(7,6,2,'11:50','13:20',6,'5号4D厅',60);



-- ----------------------------
-- Table structure for mtime_hall_film_info_t
-- ----------------------------
DROP TABLE IF EXISTS `mtime_hall_film_info_t`;
CREATE TABLE mtime_hall_film_info_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  film_id INT COMMENT '电影编号',
  film_name VARCHAR(50) COMMENT '电影名称',
  film_length VARCHAR(50) COMMENT '电影时长',  
  film_cats VARCHAR(200) COMMENT '电影类型',
  film_language VARCHAR(50) COMMENT '电影语言',
  actors VARCHAR(200) COMMENT '演员列表',
  img_address VARCHAR(500) COMMENT '图片地址'
) COMMENT '影厅电影信息表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mtime_hall_film_info_t
-- ----------------------------
INSERT INTO mtime_hall_film_info_t(UUID,film_id,film_name,film_length,film_cats,actors,film_language,img_address)
	VALUES(1,2,'我不是药神',117,'喜剧,剧情','程勇,曹斌,吕受益,刘思慧','国语2D','films/238e2dc36beae55a71cabfc14069fe78236351.jpg');
	
INSERT INTO mtime_hall_film_info_t(UUID,film_id,film_name,film_length,film_cats,actors,film_language,img_address)
	VALUES(2,3,'爱情公寓',123,'喜剧,动作,冒险','曾小贤,胡一菲,唐悠悠,张伟','国语2D','films/238e2dc36beae55a71cabfc14069fe78236351.jpg');