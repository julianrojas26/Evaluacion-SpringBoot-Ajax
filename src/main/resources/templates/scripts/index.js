$(document).ready((e) => {
  $("#button").on("click", () => {
    const table = document.querySelector("#tabla");
    table.innerHTML =
      '<table id="tabla"><thead><th>Codigo</th><th>Nombre</th><th>Categoria</th><th>Precio</th><th>Cantidad</th><th>Total-Descuento</th><th>Total</th><th>Total iva</th></thead></table>';
    $.ajax({
      url: "http://localhost:8080/listar",
      type: "GET",
      datatype: "JSON",
      success: (res) => {
        res.forEach((u) => {
          table.innerHTML +=
            "<tr><td>" +
            u.codigo +
            "</td><td>" +
            u.nombre +
            "</td><td>" +
            u.categoria +
            "</td><td>" +
            u.precio +
            "</td><td>" +
            u.cantidad +
            "</td><td>" +
            u.descuento +
            "</td><td>" +
            u.total +
            "</td><td>" +
            u.total_iva +
            "</td></tr>";
          console.log(u);
        });
      },
    });
  });

  $("#buscar").on("click", () => {
      const dato = $("#datoS").val();
      const table2 = document.querySelector("#tabla2");
      table2.innerHTML =
      '<table id="tabla"><thead><th>Codigo</th><th>Nombre</th><th>Categoria</th><th>Precio</th><th>Cantidad</th><th>Total-Descuento</th></thead></table>';
    $.ajax({
      url: "http://localhost:8080/actualizar-descuento/" + dato,
      type: "PUT",
      datatype: "JSON",
      success: (res) => {
        console.log(res);
        if (res) {
          res.forEach((u) => {
            table2.innerHTML +=
              "<tr><td>" +
              u.codigo +
              "</td><td>" +
              u.nombre +
              "</td><td>" +
              u.categoria +
              "</td><td>" +
              u.precio +
              "</td><td>" +
              u.cantidad +
              "</td><td>" +
              u.descuento +
              "</td></tr>";
            console.log(u);
          });
        } else {
          alert("Usuario no existe");
        }
      },
    });
  });

  $("#actualizar").on("click", () => {
    const table3 = document.querySelector("#tabla3");
    const codigo = parseInt($("#Codigo3").val());
    const dato = $("#dato").val();
    const nuevo = $("#nuevo").val();
    table3.innerHTML =
      '<table id="tabla"><thead><th>Codigo</th><th>Nombre</th><th>Categoria</th><th>Precio</th><th>Cantidad</th><th>Total</th></th><th>Total iva</th></thead></table>';
    $.ajax({
      url: "http://localhost:8080/buscar-codigo/" + codigo,
      type: "GET",
      datatype: "JSON",
      success: (res) => {
        if (res) {
          product = res;
            product[0].codigo = codigo;
          if (dato == "direccion") {
            product[0].nombre = nuevo;
          } else if (dato == "ciudad") {
            product[0].categoria = nuevo;
          } else if (dato == "telefono") {
            product[0].precio = parseInt(nuevo);
          } else if (dato == "correo") {
            product[0].cantidad = parseInt(nuevo);
          }
          const data = JSON.stringify(product[0]);
          console.log(data);
          $.ajax({
            url: "http://localhost:8080/actualizar-producto/" + codigo,
            type: "PUT",
            data: data,
            contentType: "application/JSON",
            success: (u) => {
                table3.innerHTML +=
                  "<tr><td>" +
                  u.codigo +
                  "</td><td>" +
                  u.nombre +
                  "</td><td>" +
                  u.categoria +
                  "</td><td>" +
                  u.precio +
                  "</td><td>" +
                  u.cantidad +
                  "</td><td>" +
                  u.total +
                  "</td><td>" +
                  u.total_iva +
                  "</td></tr>";
                console.log(u);
            },
            datatype: "JSON",
          });
        }
      },
    });
  });
});
