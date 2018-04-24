-- Transportes
INSERT INTO `basedatossuve`.`transporte` (`linea`, `tipo`) VALUES ('Roca', 'Tren');


-- Estaciones
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Glew');
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Longchamps');
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Burzaco');
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Adrogue');
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Temperley');
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'L. de Zamora');
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Banfield');
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'R. de Escalada');
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Lanus');
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Gerli');
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'D. Santillan y M. Kosteki');
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'H. Yrigoyen');
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Pza. Constitucion');

-- Secciones
INSERT INTO `basedatossuve`.`seccion` (`precio`) VALUES ('2.75');
INSERT INTO `basedatossuve`.`seccion` (`precio`) VALUES ('4');
INSERT INTO `basedatossuve`.`seccion` (`precio`) VALUES ('5.50');

-- Tramos
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '2', '1'); 	--  Glew		a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '3', '1'); 	--  Glew		a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '4', '1'); 	--  Glew		a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '5', '1'); 	--  Glew		a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '6', '2'); 	--  Glew		a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '7', '2'); 	--  Glew		a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '8', '2'); 	--  Glew		a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '9', '2'); 	--  Glew		a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '10', '2'); 	--  Glew		a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '11', '2'); 	--  Glew		a	D. Santillan y M. Kosteki
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '12', '2'); 	--  Glew		a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '13', '3'); 	--  Glew		a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '1', '1'); 	--  Longchamps	a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '3', '1'); 	--  Longchamps	a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '4', '1'); 	--  Longchamps	a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '5', '1'); 	--  Longchamps	a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '6', '1'); 	--  Longchamps	a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '7', '2'); 	--  Longchamps	a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '8', '2'); 	--  Longchamps	a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '9', '2'); 	--  Longchamps	a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '10', '2'); 	--  Longchamps	a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '11', '2'); 	--  Longchamps	a	D. Santillan y M. Kosteki
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '12', '2'); 	--  Longchamps	a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '13', '2'); 	--  Longchamps	a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '1', '1'); 	--  Burzaco	a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '2', '1'); 	--  Burzaco	a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '4', '1'); 	--  Burzaco	a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '5', '1'); 	--  Burzaco	a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '6', '1'); 	--  Burzaco	a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '7', '1'); 	--  Burzaco	a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '8', '1'); 	--  Burzaco	a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '9', '2'); 	--  Burzaco	a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '10', '2'); 	--  Burzaco	a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '11', '2'); 	--  Burzaco	a	D. Santillan y M. Kosteki
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '12', '2'); 	--  Burzaco	a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '13', '2'); 	--  Burzaco	a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '1', '1'); 	--  Adrogue	a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '2', '1'); 	--  Adrogue	a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '3', '1'); 	--  Adrogue	a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '5', '1'); 	--  Adrogue	a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '6', '1'); 	--  Adrogue	a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '7', '1'); 	--  Adrogue	a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '8', '1'); 	--  Adrogue	a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '9', '1'); 	--  Adrogue	a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '10', '2'); 	--  Adrogue	a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '11', '2'); 	--  Adrogue	a	D. Santillan y M. Kosteki
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '12', '2'); 	--  Adrogue	a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '13', '2'); 	--  Adrogue	a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '1', '1'); 	--  Temperley	a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '2', '1'); 	--  Temperley	a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '3', '1'); 	--  Temperley	a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '4', '1'); 	--  Temperley	a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '6', '1'); 	--  Temperley	a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '7', '1'); 	--  Temperley	a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '8', '1'); 	--  Temperley	a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '9', '1'); 	--  Temperley	a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '10', '1'); 	--  Temperley	a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '11', '2'); 	--  Temperley	a	D. Santillan y M. Kosteki
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '12', '2'); 	--  Temperley	a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '13', '2'); 	--  Temperley	a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '1', '2'); 	--  L. de Zamora	a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '2', '1'); 	--  L. de Zamora	a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '3', '1'); 	--  L. de Zamora	a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '4', '1'); 	--  L. de Zamora	a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '7', '1'); 	--  L. de Zamora	a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '7', '1'); 	--  L. de Zamora	a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '8', '1'); 	--  L. de Zamora	a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '9', '1'); 	--  L. de Zamora	a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '10', '1'); 	--  L. de Zamora	a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '11', '1'); 	--  L. de Zamora	a	D. Santillan y M. Kosteki
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '12', '1'); 	--  L. de Zamora	a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '13', '2'); 	--  L. de Zamora	a	Pza. Constitucion
