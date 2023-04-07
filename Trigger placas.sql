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

UPDATE licencias SET estado = 'inactivo' WHERE rfc = p_rfc AND estado = 'activo';
  
  INSERT INTO licencias (Costo, estado, fecha_expedicion, tipoCosto, vigencia, rfc)
  VALUES (p_costo, p_estado, p_fecha_expedicion, p_tipoCosto, p_vigencia, p_rfc);
  
 
  
END;$$
DELIMITER ;



