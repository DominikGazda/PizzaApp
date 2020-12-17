INSERT INTO pizza  (id_pizza,name, image_url) VALUES (1,'MARGHERITTA','https://upload.wikimedia.org/wikipedia/commons/e/ee/Eq_it-na_pizza-margherita_sep2005_sml-2.png'),
(2,'CAPRICIOSA','https://images.telepizza.com/vol/pl/images/content/productos/p2ca_c.png'),
(3,'PARMA', 'https://images.telepizza.com/vol/pl/images/content/productos/ppar_c.png'),
(4,'CAMPIONE', 'https://cdn.dagrasso.pl/static/product-images/3/6eaba06f-a4a8-11e1-bb60-005056a7f31b/15/medium/04-1.png'),
(5,'DECORO',  'https://publish.simplysmart.pl/images/products-plus/gallery/2082/5376.jpg'),
(6,'NAPOLETANA', 'https://format-com-cld-res.cloudinary.com/image/private/s--fLN2OCx---/c_crop,h_1422,w_1422,x_26,y_0/c_fill,g_center,h_1140,w_1140/a_auto,fl_keep_iptc.progressive,q_95/v1/e61c438b9cbab568a56bec692c0e7603/AnthonyMangieri_UnaPizzza.jpg');
INSERT INTO toppings (id_topping, topping_name, price) VALUES(1,'sos pomidorowy',3.5),
(2,'ser',2),
(3,'oregano',1.5),
(4,'szynka',4),
(5,'pieczarki',4),
(6,'kabanosy',5),
(7,'boczek',3.5),
(8,'papryka',2),
(9,'salami',3),
(10,'oliwki zielone',3.5);

INSERT INTO pizza_toppings (pizza_id, topping_id) VALUES (1,1),
(1,2),
(1,3),
(2,1),
(2,2),
(2,3),
(2,4),
(2,5),
(3,1),
(3,2),
(3,4),
(4,1),
(4,2),
(4,4),
(4,6),
(4,7),
(5,1),
(5,2),
(5,4),
(5,5),
(5,8),
(6,1),
(6,2),
(6,9),
(6,10),
(6,8);

INSERT INTO dough_type (id_dough_type, dough_type, price) VALUES (1,'cienkie',10),
(2,'średnie',15),
(3,'grube',20);

INSERT INTO pizza_size (id_pizza_size, size_name, topping_double_price) VALUES (1,'mała',0.8),
(2,'średnia',1),
(3,'duża',1.2);

INSERT INTO waiters (id_waiter, name, surname) VALUES (1,'Marcin','Drelo'),
(2,'Dominik','Kelner'),
(3,'Bartek','Karol');

