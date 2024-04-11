/* Vous travaillez pour une entreprise qui gère un système de gestion des employés.
La tâche consiste à mettre en place un mécanisme de suivi des modifications apportées à la table des employés (employees).
Vous devez créer des déclencheurs (triggers) distincts pour enregistrer chaque type d'action (INSERT, UPDATE, DELETE)
dans une table de journal des modifications (employee_audit_log).
*/

DELIMITER //
CREATE TRIGGER IF NOT EXISTS add_employee
AFTER INSERT
ON employees
FOR EACH ROW
BEGIN
	INSERT INTO employee_audit_log (employee_id, action_type, action_timestamp, OLD_employee_name, OLD_salary, NEW_employee_name, NEW_salary)
		VALUES (NEW.employee_id, "INSERT", NOW(), NULL, NULL, NEW.employee_name, NEW.salary);
END;
//
DELIMITER ;

-- Ajout du nouvel employé
INSERT INTO employees (employee_name, salary) VALUES ("new", 1300.64);
