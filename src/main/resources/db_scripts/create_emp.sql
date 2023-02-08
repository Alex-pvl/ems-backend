create function create_emp(_first_name character varying, _last_name character varying, _email character varying, _department integer, _role_id integer) returns integer
    language plpgsql
as
$$
DECLARE
    _id integer;
BEGIN
    insert into employees(first_name, last_name, email, department_id, role_id)
    values (_first_name, _last_name, _email, _department, _role_id);

    select id into _id from employees where first_name like _first_name;

    return _id;
END
$$;

comment on function create_emp(varchar, varchar, varchar, integer, integer) is 'Создание нового работника';

alter function create_emp(varchar, varchar, varchar, integer, integer) owner to root;

