# admin-io-backendv2

Este es el backend de nuestra página web

**Consultas:**
## POST
#### CREAR
*Para probar en Postman usa body raw JSON*

localhost:8080/adminapi/v1/createMember

    {
    "name_member": "Elias",
    "email_member": "prueabitajhbjhb@gmail.com",
    "password_member": "noel",
    "phone_member": 1022210,
    "description_member": "asasas"
    }

localhost:8080/adminapi/v1/createWork

    {
    "name_work": "tarea",
    "description_work" : "esta es una descripcion",
    "priority_work": "high",
    "process_work":"pendiente",
    "startdate_work": "2022-01-01",
    "enddate_work": "2022-02-01"
    }

localhost:8080/adminapi/v1/createAdmin

    {
    "name_administrator": "Elias",
    "email_administrator": "pruebitaxx@gmail.com",
    "password_administrator": "noel",
    "phone_administrator": 1022210,
    "description_administrator": "asasas"
    }

## GET
#### CONSULTAR
- localhost:8080/adminapi/v1/getMembers
- localhost:8080/adminapi/v1/getWorks
- localhost:8080/adminapi/v1/getAdmins
- localhost:8080/adminapi/v1/getWorkgroups
- localhost:8080/adminapi/v1/getMember?id=1 (cambiar el id)
- localhost:8080/adminapi/v1/getWork?id=1 (cambiar el id)
- localhost:8080/adminapi/v1/getAdmin?id=1 (cambiar el id)
- localhost:8080/adminapi/v1/getWorkgroup?id=1 (cambiar el id)

### DELETE
- localhost:8080/adminapi/v1/deleteMember?id=1
- localhost:8080/adminapi/v1/deleteAdmin?id=1
- localhost:8080/adminapi/v1/deleteWork?id=1
- localhost:8080/adminapi/v1/deleteWorkgroup?id=1

## Integrantes
- **Noeli Rodriguez Morales**
- **Aldo Aaron Meza Moreno**
- Sebastian Emiliano Romero Martinez
- Viviana Mendez Lopez


### Desarrolladores BACKEND
- Noeli Rodriguez Morales
- Aldo Aaron Meza Moreno