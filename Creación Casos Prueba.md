## Identificar las variables que se deben tener en cuenta para probar el método de interés.
        - sana: boolean
        - sintomas: boolean
        - contacto: boolean
        - pasado_covid: boolean
        - cartilla_en_regla: boolean
        - temperatura: double
        - humedad: double
        - nieva: boolean
        - llueve: boolean
        - nublado: boolean
        - aforo_max: int
        - confinada: boolean


## Identificar los valores de pruebas para cada una de las variables anteriores usando las tres técnicas vistas en teoría, especificando para cada una cual es la que ha sido usada.

# Parámetros y Clases de Equivalencia

| Parámetro             | Clases de Equivalencia                              | Selección de Valores                   | Extremos                                                 |
|-----------------------|-----------------------------------------------------|----------------------------------------|----------------------------------------------------------|
| **sano**              | false, true                                         | false, true                            | false, true                                              |
| **sintomas**          | false, true                                         | false, true                            | false, true                                              |
| **contacto**          | false, true                                         | false, true                            | false, true                                              |
| **pasado_covid**      | false, true                                         | false, true                            | false, true                                              |
| **cartilla_en_regla** | false, true                                         | false, true                            | false, true                                              |
| **temperatura**       | (-∞, 0), [0,15), [15,25), [25,30), [30,35), [35,+∞) | -15, 5, 20, 27, 32, 50                 | -1, 0, 1, 14, 15, 16, 24, 25, 26, 29, 30, 31, 34, 35, 36 |
| **humedad**           | (-∞, 0), [0,15), [15,60), [60,+∞)                   | -800, 12, 37, 80                       | -1, 0, 1, 14, 15, 16, 59, 60, 61                         |
| **nieva**             | false, true                                         | false, true                            | false, true                                              |
| **llueve**            | false, true                                         | false, true                            | false, true                                              |
| **nublado**           | false, true                                         | false, true                            | false, true                                              |
| **aforo_max**         | (-∞, 0), [0, +∞)                                    | -25, 400                               | -1, 0, 1                                                 |
| **confinada**         | false, true                                         | false, true                            | false, true                                              |

# Conjetura de Errores

- **temperatura**: 200
- **humedad**: 220
- **aforo_max**: 1,000,000


## Calcular el número máximo posible de casos de pruebas que se podrían generar a partir de los valores de pruebas (combinatoria).
        - sana: 2
        - sintomas: 2
        - contacto: 2
        - pasado_covid: 2
        - cartilla_en_regla: 2
        - temperatura: 22
        - humedad: 14
        - nieva: 2
        - llueve: 2
        - nublado: 2
        - aforo_max: 6
        - confinada: 2
        
        - TOTAL = 2^169                                                             |
        

## Defina un conjunto de casos de pruebas para cumplir con each use (cada valor una vez)
| sana  | sintomas | contacto | pasado_covid | cartilla_en_regla | temperatura | humedad | nieva | llueve | nublado | aforo_max | confinada |
|-------|----------|----------|--------------|-------------------|-------------|---------|-------|--------|---------|-----------|-----------|
| false | true     | false    | true         | false             | -15         | -800    | true  | false  | true    | -25       | false     |
| true  | false    | true     | false        | true              | -1          | -1      | false | true   | false   | -1        | true      |
| false | true     | false    | true         | false             | 0           | 0       | true  | false  | true    | 0         | false     |
| true  | false    | true     | false        | true              | 1           | 1       | false | true   | false   | 1         | true      |
| false | true     | false    | true         | false             | 5           | 12      | true  | false  | true    | 400       | false     |
| true  | false    | true     | false        | true              | 14          | 14      | false | true   | false   | 1000000   | true      |
| false | true     | false    | true         | false             | 15          | 15      | true  | false  | true    | -25       | false     |
| true  | false    | true     | false        | true              | 16          | 16      | false | true   | false   | -1        | true      |
| false | true     | false    | true         | false             | 20          | 37      | true  | false  | true    | 0         | false     |
| true  | false    | true     | false        | true              | 24          | 59      | false | true   | false   | 1         | true      |
| false | true     | false    | true         | false             | 25          | 60      | true  | false  | true    | 400       | false     |
| true  | false    | true     | false        | true              | 26          | 61      | false | true   | false   | 1000000   | true      |
| false | true     | false    | true         | false             | 27          | 80      | true  | false  | true    | -25       | false     |
| true  | false    | true     | false        | true              | 29          | 220     | false | true   | false   | -1        | true      |
| false | true     | false    | true         | false             | 30          | -15     | true  | false  | true    | 0         | false     |
| true  | false    | true     | false        | true              | 31          | -1      | false | true   | false   | 1         | true      |
| false | true     | false    | true         | false             | 32          | 0       | true  | false  | true    | 400       | false     |
| true  | false    | true     | false        | true              | 34          | 1       | false | true   | false   | 1000000   | true      |
| false | true     | false    | true         | false             | 35          | 12      | true  | false  | true    | -25       | false     |
| true  | false    | true     | false        | true              | 36          | 14      | false | true   | false   | -1        | true      |
| false | true     | false    | true         | false             | 50          | 15      | true  | false  | true    | 0         | false     |
| true  | false    | true     | false        | true              | 200         | 16      | false | true   | false   | 1         | true      |



## Defina conjuntos de pruebas para alcanzar cobertura pairwaise usando el algoritmo explicado en clase. Se pueden comprobar los resultados con el programa PICT
| sana  | sintomas | contacto | pasado_covid | cartilla_en_regla | temperatura | humedad | nieva | llueve | nublado | aforo_max | confinada |
|-------|----------|----------|--------------|-------------------|-------------|---------|-------|--------|---------|-----------|-----------|
| true  | true     | false    | true         | false             | 34          | 14      | true  | true   | false   | 400       | false     |
| true  | false    | true     | false        | true              | 0           | 0       | false | false  | true    | 1         | true      |
| false | true     | true     | true         | true              | 20          | -800    | true  | false  | false   | -25       | true      |
| false | false    | false    | false        | false             | 16          | 37      | false | true   | true    | 1000000   | false     |
| true  | true     | false    | false        | true              | 200         | 15      | true  | false  | true    | -1        | false     |
| true  | false    | true     | true         | false             | 15          | 1       | false | true   | false   | 0         | true      |
| true  | true     | false    | false        | true              | 15          | 16      | false | true   | true    | -25       | false     |
| false | false    | false    | true         | false             | 14          | 12      | false | false  | true    | 400       | true      |
| true  | true     | true     | true         | true              | 16          | 12      | true  | true   | false   | 1         | false     |
| true  | false    | true     | false        | false             | 20          | 16      | true  | false  | false   | 1000000   | true      |
| false | false    | true     | true         | false             | 1           | 80      | false | true   | false   | -1        | true      |
| false | true     | false    | false        | true              | 35          | 1       | true  | false  | true    | 0         | false     |
| false | false    | true     | false        | false             | 34          | 59      | false | false  | true    | 1         | true      |
| false | false    | true     | false        | true              | 15          | 61      | true  | false  | true    | 400       | true      |
| true  | true     | false    | false        | true              | 1           | -800    | false | true   | true    | 1000000   | false     |
| false | false    | true     | true         | false             | -15         | 15      | false | true   | false   | -25       | true      |
| false | false    | false    | true         | false             | 200         | 61      | false | true   | false   | 1         | true      |
| false | false    | false    | true         | false             | -1          | 12      | false | false  | false   | 1000000   | true      |
| true  | true     | true     | true         | true              | -1          | 37      | true  | true   | true    | -25       | true      |
| false | true     | false    | true         | false             | 0           | 1       | true  | true   | false   | 1000000   | false     |
| false | false    | true     | false        | true              | 5           | 14      | false | false  | true    | 1000000   | true      |
| true  | false    | true     | true         | true              | 0           | 15      | false | true   | true    | 0         | true      |
| true  | true     | false    | true         | true              | 0           | 59      | true  | true   | false   | -25       | false     |
| true  | false    | true     | false        | false             | 31          | -800    | true  | false  | true    | 400       | true      |
| true  | false    | true     | true         | false             | 35          | 59      | false | true   | false   | -1        | true      |
| true  | true     | false    | true         | true              | 31          | 80      | false | true   | false   | 1000000   | false     |
| true  | false    | true     | true         | false             | 35          | 37      | false | false  | false   | 1         | false     |
| true  | false    | true     | false        | true              | 34          | 15      | false | false  | false   | 1000000   | true      |
| true  | true     | true     | true         | false             | 29          | 61      | false | true   | false   | -25       | false     |
| true  | false    | false    | true         | true              | 50          | 61      | true  | false  | false   | -1        | false     |
| true  | true     | false    | true         | false             | 15          | 60      | false | false  | false   | 1000000   | false     |
| false | false    | false    | false        | false             | 0           | 14      | false | false  | false   | -1        | false     |
| false | false    | true     | false        | false             | 16          | 80      | true  | false  | true    | 0         | true      |
| false | false    | false    | false        | false             | -1          | 80      | false | true   | true    | 1         | false     |
| false | false    | true     | false        | true              | 25          | 60      | true  | true   | true    | 1         | true      |
| false | true     | false    | true         | false             | 27          | 16      | false | true   | true    | 400       | true      |
| false | true     | true     | false        | true              | 36          | 1       | true  | true   | true    | 1         | true      |
| true  | true     | false    | false        | true              | -15         | 59      | true  | false  | true    | 0         | false     |
| false | true     | false    | false        | false             | 31          | -1      | false | false  | false   | -25       | false     |
| false | true     | false    | true         | false             | 15          | 59      | true  | false  | false   | 1         | true      |
| false | false    | true     | true         | false             | 32          | 220     | true  | true   | true    | -1        | true      |
| true  | true     | false    | false        | true              | 15          | 220     | false | false  | false   | -1        | false     |
| false | true     | false    | true         | false             | 16          | 0       | true  | true   | false   | 400       | false     |
| false | true     | true     | false        | false             | 50          | -1      | true  | true   | true    | 400       | true      |
| true  | false    | false    | true         | false             | 16          | -800    | true  | true   | false   | -1        | true      |
| false | false    | false    | false        | true              | 29          | -1      | true  | false  | true    | 1000000   | true      |
| false | true     | false    | true         | true              | 50          | 80      | false | true   | true    | -25       | false     |
| true  | true     | true     | false        | true              | 14          | 14      | true  | true   | false   | 1         | false     |
| true  | true     | true     | true         | false             | 24          | 80      | false | true   | true    | 400       | false     |
| true  | true     | false    | false        | false             | 26          | 12      | false | true   | false   | -25       | false     |
| false | false    | false    | true         | false             | 50          | 16      | false | true   | true    | 1         | true      |
| false | true     | true     | false        | false             | 20          | 1       | true  | true   | false   | -1        | true      |
| false | false    | true     | true         | false             | 15          | 14      | false | false  | true    | -25       | true      |
| true  | true     | false    | true         | false             | 16          | 12      | true  | false  | false   | 400       | false     |


## Para los trozos de código que incluyan decisiones, proponga conjunto de casos de prueba para
alcanzar cobertura de decisiones
| Caso | sana  | sintomas | contacto | pasado_covid | cartilla_en_regla | temperatura | humedad | nieva | llueve | nublado | aforo_actual | aforo_max | confinada | Actividad Esperada |
|------|-------|----------|----------|--------------|-------------------|-------------|---------|-------|--------|---------|--------------|-----------|-----------|-------------------|
| 1    | false | false    | false    | false        | false             | -20         | 10      | false | false  | false   | 0            | 10        | false     | NADA              |
| 2    | true  | false    | false    | true         | true              | -10         | 10      | true  | false  | false   | 0            | 10        | false     | CASA              |
| 3    | true  | false    | false    | true         | true              | -5          | 10      | false | false  | false   | 0            | 10        | false     | ESQUIAR           |
| 4    | true  | false    | false    | true         | true              | 5           | 50      | false | false  | false   | 0            | 10        | false     | SENDERISMO        |
| 5    | true  | false    | false    | true         | true              | 16          | 50      | false | false  | false   | 0            | 10        | false     | TURISMO           |
| 6    | true  | false    | false    | true         | true              | 25          | 50      | false | false  | false   | 0            | 10        | false     | CAÑAS            |
| 7    | true  | false    | false    | true         | true              | 30          | 50      | false | false  | false   | 0            | 10        | false     | PISCINA           |
| 8    | true  | false    | false    | true         | true              | 30          | 50      | false | false  | false   | 10           | 10        | false     | PLAYA             |


## Para los trozos de código que incluyan decisiones, proponga conjunto de casos de prueba para
alcanzar cobertura MC/DC
| Caso | sana  | sintomas | contacto | pasado_covid | cartilla_en_regla | temperatura | humedad | nieva | llueve | nublado | aforo_actual | aforo_max | confinada | Actividad Esperada |
|------|-------|----------|----------|--------------|-------------------|-------------|---------|-------|--------|---------|--------------|-----------|-----------|-------------------|
| 1    | false | false    | false    | false        | false             | -20         | 10      | false | false  | false   | 0            | 10        | false     | NADA              |
| 2    | true  | false    | false    | true         | true              | -10         | 10      | true  | false  | false   | 0            | 10        | false     | CASA              |
| 3    | true  | false    | false    | true         | true              | -5          | 10      | false | false  | false   | 0            | 10        | false     | ESQUIAR           |
| 4    | true  | false    | false    | true         | true              | 5           | 50      | false | false  | false   | 0            | 10        | false     | SENDERISMO        |
| 5    | true  | false    | false    | true         | true              | 16          | 50      | false | false  | false   | 0            | 10        | false     | TURISMO           |
| 6    | true  | false    | false    | true         | true              | 25          | 50      | false | false  | false   | 0            | 10        | false     | CAÑAS            |
| 7    | true  | false    | false    | true         | true              | 30          | 50      | false | false  | false   | 0            | 10        | false     | PISCINA           |
| 8    | true  | false    | false    | true         | true              | 30          | 50      | false | false  | false   | 10           | 10        | false     | PLAYA             |
| 9    | true  | true     | false    | true         | true              | 5           | 50      | false | false  | false   | 0            | 10        | false     | NADA              |
| 10   | true  | false    | true     | true         | true              | 16          | 50      | false | false  | false   | 0            | 10        | false     | NADA              |
| 11   | true  | false    | false    | false        | true              | 16          | 50      | false | false  | false   | 0            | 10        | false     | NADA              |
| 12   | true  | false    | false    | true         | false             | 16          | 50      | false | false  | false   | 0            | 10        | false     | NADA              |
| 13   | true  | false    | false    | true         | true              | -5          | 10      | false | true   | false   | 0            | 10        | false     | NADA              |
| 14   | true  | false    | false    | true         | true              | 16          | 50      | false | false  | true    | 0            | 10        | false     | NADA              |
| 15   | true  | false    | false    | true         | true              | 16          | 100     | false | false  | false   | 0            | 10        | false     | NADA              |
| 16   | true  | false    | false    | true         | true              | 16          | 50      | false | false  | false   | 0            | 0         | false     | NADA              |


## Comente los resultados del número de los casos de pruebas conseguidos en los apartados 4, 5 y 6 ¿qué podría decirse de la cobertura alcanzada?
En el apartado 4 nos da un resultado desorbitado que, aunque cubra completamente todo el código, no merece la pena. En los apartados 5 y 6 se reducen muchísimo el número de casos de prueba a realizar y se consigue una cobertura muy parecida en cuanto a extensión.
