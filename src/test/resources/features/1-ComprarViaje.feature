Feature: Módulo para la compra de pasajes

  @ComprarTicketServicioBelmond @Regresion
  Scenario Outline: 1-Validar que se pueda realizar compras seleccionando el servicio BELMOND ANDEAN EXPLORER
    Given que accedo a la página principal de Perú Rail
    And ingreso el tipo de pasaje ida o vuelta "<tipo_pasaje>"
    And ingreso los datos del destino: "<destino>", "<ruta>" y "<tren>"
    And selecciona la fecha de ida y/o regreso: "<fecha_ida>" y/o "<fecha_regreso>"
    And realizo la busqueda
    And selecciono el tipo "<tipo_cabina>" y número de cabinas "<num_cabinas>" a reservar
    And selecciono la cantidad de pasajeros "<numero_adultos>" y "<numero_ninos>"
    And ingreso los datos de los pasajeros
    And realizo la compra con medio de pago "<medio_pago>"
    Then valido el detalle de la compra

    Examples: 
      | tipo_pasaje | destino | ruta         | tren                             | fecha_ida  | fecha_regreso | tipo_cabina  | num_cabinas | numero_adultos | numero_ninos | medio_pago |
      | One Way     | Cusco   | Puno > Cusco | Andean Explorer, A Belmond Train | 22-06-2022 | NA            | SUITE CABINS | 1 CABIN     |              1 |            1 | visa       |
      | One Way     | Cusco   | Puno > Cusco | Andean Explorer, A Belmond Train | 22-06-2022 | NA            | SUITE CABINS | 2 CABINS    | 1-2            | 1-0          | visa       |

  #  	| One Way     | Cusco   | Puno > Cusco | Andean Explorer, A Belmond Train | 22-06-2022 | NA            | TWIN BED CABINS | 3 CABINS    | 1-2-1          | 1-0-1        | visa       |
  @ComprarTicketTrenExpedition
  Scenario Outline: 2-Validar que se pueda realizar compras de tren Expedite
    Given que accedo a la página principal de Perú Rail
    And ingreso el tipo de pasaje ida o vuelta "<tipo_pasaje>"
    And ingreso los datos del destino: "<destino>", "<ruta>" y "<tren>"
    And selecciona la fecha de ida y/o regreso: "<fecha_ida>" y/o "<fecha_regreso>"
    And ingreso la cantidad de pasajeros "<numero_adultos>" y "<numero_ninos>"
    And realizo la busqueda
    And selecciono el tren de partida "<tren_partida>" y regreso "<tren_regreso>"
    And ingreso los datos de los pasajeros expedite
    Then valido los montos de la compra y realizo pago "<medio_pago>"

    Examples: 
      | tipo_pasaje | destino      | ruta                 | tren | fecha_ida  | fecha_regreso | numero_adultos | numero_ninos | tren_partida  | tren_regreso | medio_pago |
      | One Way     | Machu Picchu | Cusco > Machu Picchu | NA   | 02-02-2022 | NA            |              2 |            2 | Expedition 33 | NA           | visa       |
      | Round trip  | Machu Picchu | Cusco > Machu Picchu | NA   | 02-02-2022 | 24-02-2022    |              4 |            2 | Expedition 33 | Vistadome 34 | visa       |
      | Round trip  | Machu Picchu | Cusco > Machu Picchu | NA   | 02-02-2022 | 24-02-2022    |              2 |            2 | Expedition 33 | Vistadome 34 | visa       |

  @ValidarMaximoNumeroPasajeros @Regresion
  Scenario Outline: 3-Validar que muestra mensaje de error al tratar de registrar mas de 9 pasajeros
    Given que accedo a la página principal de Perú Rail
    And ingreso el tipo de pasaje ida o vuelta "<tipo_pasaje>"
    And ingreso los datos del destino: "<destino>", "<ruta>" y "<tren>"
    And selecciona la fecha de ida y/o regreso: "<fecha_ida>" y/o "<fecha_regreso>"
    And ingreso más de la cantidad máxima de pasajeros "<numero_adultos>" y "<numero_ninos>"
    Then valido que se muestre mensaje de error "Only up to 9 tickets "

    Examples: 
      | tipo_pasaje | destino      | ruta                 | tren | fecha_ida  | fecha_regreso | numero_adultos | numero_ninos |
      | One Way     | Machu Picchu | Cusco > Machu Picchu | NA   | 22-06-2022 | NA            |              8 |            2 |
      | Round trip  | Machu Picchu | Cusco > Machu Picchu | NA   | 22-06-2022 | 28-06-2022    |              5 |            6 |
      | Round trip  | Machu Picchu | Cusco > Machu Picchu | NA   | 22-06-2022 | 28-06-2022    |              9 |            1 |
