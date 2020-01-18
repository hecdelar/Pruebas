##Para la ejecucion de este Proyecto es necesario Java JDK 11
## Comando Para Ejecutar dentro del directorio Proyectos_java\restBinaryTree\target
java -jar restBinaryTree-0.0.1-SNAPSHOT.jar

##para consumir los servicios existen dos metodos
## obtener un arbo binario de maximo 20 nodos
GET http://localhost:8080/management/tree/binarytree/


##obtener el ancestro de dos nodos
GET http://localhost:8080/management/tree/binarytree/Ancestor?pNodeOne=92&pNodeTwo=93
## adicionalmente  sa debe pasar por body el arbol donse se busca, se puede pasar el
arbol obtenido del metodo anterior. o EJ
{
    "value": 95,
    "left": {
        "value": 27,
        "left": {
            "value": 6,
            "left": {
                "value": 5,
                "left": null,
                "right": null
            },
            "right": {
                "value": 12,
                "left": {
                    "value": 10,
                    "left": null,
                    "right": null
                },
                "right": {
                    "value": 22,
                    "left": null,
                    "right": null
                }
            }
        },
        "right": {
            "value": 83,
            "left": {
                "value": 60,
                "left": {
                    "value": 39,
                    "left": {
                        "value": 29,
                        "left": null,
                        "right": {
                            "value": 37,
                            "left": null,
                            "right": null
                        }
                    },
                    "right": {
                        "value": 53,
                        "left": {
                            "value": 43,
                            "left": null,
                            "right": null
                        },
                        "right": {
                            "value": 55,
                            "left": null,
                            "right": null
                        }
                    }
                },
                "right": {
                    "value": 71,
                    "left": {
                        "value": 62,
                        "left": null,
                        "right": null
                    },
                    "right": null
                }
            },
            "right": {
                "value": 92,
                "left": null,
                "right": {
                    "value": 93,
                    "left": null,
                    "right": null
                }
            }
        }
    },
    "right": {
        "value": 99,
        "left": null,
        "right": null
    }
}
