-- Transportes
INSERT INTO `basedatossuve`.`transporte` (`linea`, `tipo`) VALUES ('Roca', 'Tren');

-- Estaciones
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Glew');					-- 1
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Longchamps');			-- 2
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Burzaco');				-- 3
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Adrogue');				-- 4
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Temperley');			-- 5
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'L. de Zamora');			-- 6
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Banfield');				-- 7
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'R. de Escalada');		-- 8
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Lanus');				-- 9
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Gerli');				-- 10
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'D. y M.');				-- 11
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'H. Yrigoyen');			-- 12
INSERT INTO `basedatossuve`.`estacion` (`idTransporte`, `nombre`) VALUES ('1', 'Pza. Constitucion');	-- 13

-- Secciones
INSERT INTO `basedatossuve`.`seccion` (`precio`) VALUES ('2.75');
INSERT INTO `basedatossuve`.`seccion` (`precio`) VALUES ('4');
INSERT INTO `basedatossuve`.`seccion` (`precio`) VALUES ('5.50');

-- Tramos
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '2', '1'); 	--  Glew				a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '3', '1'); 	--  Glew				a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '4', '1'); 	--  Glew				a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '5', '1'); 	--  Glew				a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '6', '2'); 	--  Glew				a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '7', '2'); 	--  Glew				a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '8', '2'); 	--  Glew				a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '9', '2'); 	--  Glew				a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '10', '2'); 	--  Glew				a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '11', '2'); 	--  Glew				a	D. y M.
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '12', '2'); 	--  Glew				a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('1', '13', '3'); 	--  Glew				a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '1', '1'); 	--  Longchamps			a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '3', '1'); 	--  Longchamps			a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '4', '1'); 	--  Longchamps			a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '5', '1'); 	--  Longchamps			a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '6', '1'); 	--  Longchamps			a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '7', '2'); 	--  Longchamps			a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '8', '2'); 	--  Longchamps			a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '9', '2'); 	--  Longchamps			a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '10', '2'); 	--  Longchamps			a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '11', '2'); 	--  Longchamps			a	D. y M.
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '12', '2'); 	--  Longchamps			a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('2', '13', '2'); 	--  Longchamps			a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '1', '1'); 	--  Burzaco				a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '2', '1'); 	--  Burzaco				a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '4', '1'); 	--  Burzaco				a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '5', '1'); 	--  Burzaco				a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '6', '1'); 	--  Burzaco				a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '7', '1'); 	--  Burzaco				a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '8', '1'); 	--  Burzaco				a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '9', '2'); 	--  Burzaco				a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '10', '2'); 	--  Burzaco				a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '11', '2'); 	--  Burzaco				a	D. y M.
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '12', '2'); 	--  Burzaco				a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('3', '13', '2'); 	--  Burzaco				a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '1', '1'); 	--  Adrogue				a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '2', '1'); 	--  Adrogue				a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '3', '1'); 	--  Adrogue				a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '5', '1'); 	--  Adrogue				a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '6', '1'); 	--  Adrogue				a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '7', '1'); 	--  Adrogue				a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '8', '1'); 	--  Adrogue				a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '9', '1'); 	--  Adrogue				a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '10', '2'); 	--  Adrogue				a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '11', '2'); 	--  Adrogue				a	D. y M.
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '12', '2'); 	--  Adrogue				a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('4', '13', '2'); 	--  Adrogue				a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '1', '1'); 	--  Temperley			a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '2', '1'); 	--  Temperley			a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '3', '1'); 	--  Temperley			a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '4', '1'); 	--  Temperley			a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '6', '1'); 	--  Temperley			a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '7', '1'); 	--  Temperley			a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '8', '1'); 	--  Temperley			a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '9', '1'); 	--  Temperley			a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '10', '1'); 	--  Temperley			a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '11', '2'); 	--  Temperley			a	D. y M.
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '12', '2'); 	--  Temperley			a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('5', '13', '2'); 	--  Temperley			a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '1', '2'); 	--  L. de Zamora		a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '2', '1'); 	--  L. de Zamora		a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '3', '1'); 	--  L. de Zamora		a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '4', '1'); 	--  L. de Zamora		a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '7', '1'); 	--  L. de Zamora		a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '7', '1'); 	--  L. de Zamora		a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '8', '1'); 	--  L. de Zamora		a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '9', '1'); 	--  L. de Zamora		a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '10', '1'); 	--  L. de Zamora		a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '11', '1'); 	--  L. de Zamora		a	D. y M.
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '12', '1'); 	--  L. de Zamora		a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('6', '13', '2'); 	--  L. de Zamora		a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('7', '1', '2'); 	--  Bandfield			a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('7', '2', '2'); 	--  Bandfield			a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('7', '3', '1'); 	--  Bandfield			a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('7', '4', '1'); 	--  Bandfield			a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('7', '5', '1'); 	--  Bandfield			a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('7', '6', '1'); 	--  Bandfield			a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('7', '8', '1'); 	--  Bandfield			a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('7', '9', '1'); 	--  Bandfield			a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('7', '10', '1'); 	--  Bandfield			a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('7', '11', '1'); 	--  Bandfield			a	D. y M.
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('7', '12', '1'); 	--  Bandfield			a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('7', '13', '2'); 	--  Bandfield			a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('8', '1', '2'); 	--  R. de Escalada		a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('8', '2', '2'); 	--  R. de Escalada		a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('8', '3', '1'); 	--  R. de Escalada		a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('8', '4', '1'); 	--  R. de Escalada		a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('8', '5', '1'); 	--  R. de Escalada		a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('8', '6', '1'); 	--  R. de Escalada		a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('8', '7', '1'); 	--  R. de Escalada		a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('8', '9', '1'); 	--  R. de Escalada		a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('8', '10', '1'); 	--  R. de Escalada		a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('8', '11', '1'); 	--  R. de Escalada		a	D. y M.
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('8', '12', '1'); 	--  R. de Escalada		a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('8', '13', '1'); 	--  R. de Escalada		a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('9', '1', '2'); 	--  Lanus				a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('9', '2', '2'); 	--  Lanus				a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('9', '3', '2'); 	--  Lanus				a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('9', '4', '1'); 	--  Lanus				a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('9', '5', '1'); 	--  Lanus				a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('9', '6', '1'); 	--  Lanus				a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('9', '7', '1'); 	--  Lanus				a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('9', '8', '1'); 	--  Lanus				a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('9', '10', '1'); 	--  Lanus				a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('9', '11', '1'); 	--  Lanus				a	D. y M.
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('9', '12', '1'); 	--  Lanus				a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('9', '13', '1'); 	--  Lanus				a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('10', '1', '2'); 	--  Gerli				a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('10', '2', '2'); 	--  Gerli				a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('10', '3', '2'); 	--  Gerli				a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('10', '4', '2'); 	--  Gerli				a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('10', '5', '1'); 	--  Gerli				a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('10', '6', '1'); 	--  Gerli				a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('10', '7', '1'); 	--  Gerli				a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('10', '8', '1'); 	--  Gerli				a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('10', '9', '1'); 	--  Gerli				a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('10', '11', '1'); 	--  Gerli				a	D. y M.
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('10', '12', '1'); 	--  Gerli				a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('10', '13', '1'); 	--  Gerli				a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('11', '1', '2'); 	-- D. y M.				a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('11', '2', '2'); 	-- D. y M.				a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('11', '3', '2'); 	-- D. y M.				a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('11', '4', '2'); 	-- D. y M.				a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('11', '5', '2'); 	-- D. y M.				a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('11', '6', '1'); 	-- D. y M.				a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('11', '7', '1'); 	-- D. y M.				a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('11', '8', '1'); 	-- D. y M.				a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('11', '9', '1'); 	-- D. y M.				a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('11', '10', '1'); 	-- D. y M.				a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('11', '12', '1'); 	-- D. y M.				a	H. Yrigoyen
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('11', '13', '1'); 	-- D. y M.				a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('12', '1', '2'); 	--  H. Yrigoyen			a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('12', '2', '2'); 	--  H. Yrigoyen			a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('12', '3', '2'); 	--  H. Yrigoyen			a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('12', '4', '2'); 	--  H. Yrigoyen			a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('12', '5', '2'); 	--  H. Yrigoyen			a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('12', '6', '1'); 	--  H. Yrigoyen			a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('12', '7', '1'); 	--  H. Yrigoyen			a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('12', '8', '1'); 	--  H. Yrigoyen			a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('12', '9', '1'); 	--  H. Yrigoyen			a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('12', '10', '1'); 	--  H. Yrigoyen			a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('12', '11', '1'); 	--  H. Yrigoyen			a	D. y M.
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('12', '13', '1'); 	--  H. Yrigoyen			a	Pza. Constitucion

INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('13', '1', '2'); 	--  Pza. Constitucion	a	Glew
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('13', '2', '2'); 	--  Pza. Constitucion	a	Longchamps
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('13', '3', '2'); 	--  Pza. Constitucion	a	Burzaco
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('13', '4', '2'); 	--  Pza. Constitucion	a	Adrogue
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('13', '5', '2'); 	--  Pza. Constitucion	a	Temperley
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('13', '6', '1'); 	--  Pza. Constitucion	a	L. de Zamora
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('13', '7', '1'); 	--  Pza. Constitucion	a	Bandfield
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('13', '8', '1'); 	--  Pza. Constitucion	a	R. de Escalada
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('13', '9', '1'); 	--  Pza. Constitucion	a	Lanus
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('13', '10', '1'); 	--  Pza. Constitucion	a	Gerli
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('13', '11', '1'); 	--  Pza. Constitucion	a	D. y M.
INSERT INTO `basedatossuve`.`tramo` (`eIngreso`, `eSalida`, `idSeccion`) VALUES ('13', '12', '1');	--  Pza. Constitucion	a	H. Yrigoyen