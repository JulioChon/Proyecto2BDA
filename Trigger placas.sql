DELIMITER $$
CREATE TRIGGER generar_placas
BEFORE INSERT ON placas
FOR EACH ROW
BEGIN
  SET @letras = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
  SET NEW.serie = CONCAT(
    SUBSTRING(@letras, FLOOR(RAND() * 26) + 1, 1),
    SUBSTRING(@letras, FLOOR(RAND() * 26) + 1, 1),
    SUBSTRING(@letras, FLOOR(RAND() * 26) + 1, 1),
    '-',
    LPAD(FLOOR(RAND() * 1000), 3, '0')
  );
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE actualizar_licencias (IN p_costo DECIMAL(10,2), IN p_estado VARCHAR(20), IN p_fecha_expedicion DATE, IN p_tipoCosto VARCHAR(20), IN p_vigencia DATE, IN p_rfc VARCHAR(20))
BEGIN

UPDATE licencias SET estado = 'Inactivo' WHERE rfc = p_rfc AND estado = 'Activo';
  
  INSERT INTO licencias (Costo, estado, fecha_expedicion, tipoCosto, vigencia, rfc,tipoTramite)
  VALUES (p_costo, p_estado, p_fecha_expedicion, p_tipoCosto, p_vigencia, p_rfc,"Licencias");
END;$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE actualizar_placas(
    IN p_numero_serie VARCHAR(10),
    IN p_fecha_entrega DATE,
    IN p_fecha_expedicion DATE,
    IN p_vigencia Date,
    IN p_tipo_placa VARCHAR(50),
    IN p_rfc VARCHAR(50),
    IN p_costo DECIMAL(10,2),
    IN p_estado VARCHAR(20)
)
BEGIN
  
  UPDATE placas SET estado = 'Inactivo'
  WHERE numeroserie = p_numero_serie;
  

  INSERT INTO placas (numeroserie, fecha_entrega, fecha_expedicion, vigencia, tipoPlaca, rfc, costo, estado,tipoTramite)
  VALUES (p_numero_serie, p_fecha_entrega, p_fecha_expedicion, p_vigencia, p_tipo_placa, p_rfc, p_costo, p_estado,"Placas");
END;$$
DELIMITER ;




