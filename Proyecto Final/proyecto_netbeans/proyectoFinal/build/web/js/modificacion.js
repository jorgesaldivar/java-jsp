function trim(value) {
   var temp = value;
   var obj = /^(\s*)([\W\w]*)(\b\s*$)/;
   if (obj.test(temp)) { temp = temp.replace(obj, '$2');}
   var obj = /  /g;
   while (temp.match(obj)) { temp = temp.replace(obj, " ");}
   return temp;
}

//Funcion para calcular el largo en pixels det texto dado
function getTextWidth(texto)
{
	//Valor por default : 150 pixels
	var ancho = 150;

	if(trim(texto) == "")
	{
		return ancho;
	}

	//Creaci�n de un span escondido que se puedr� medir 
	var span = document.createElement("span");
	span.style.visibility = "hidden";
	span.style.position = "absolute";

	//Se agrega el texto al span y el span a la p�gina
	span.appendChild(document.createTextNode(texto));
	document.getElementsByTagName("body")[0].appendChild(span);

	//tama�o del texto
	ancho = span.offsetWidth;

	//Eliminaci�n del span
	document.getElementsByTagName("body")[0].removeChild(span);
	span = null;

	return ancho;
}


//Funcion de modificacion del elemento seleccionado mediante doble-click
function modificar(obj)
{ 
	//Objeto que sirve para editar el valor en la pagina 
	var input = null;

	input = document.createElement("input");


	//Asignar en la caja el valor de la casilla
	if (obj.innerText)
		input.value = obj.innerText;
	else
		input.value = obj.textContent;
	input.value = trim(input.value);

	//a la caja INPUT se la asigna un tama�o un poco mayor que el texto a modificar
	input.style.width  = getTextWidth(input.value) + 30 + "px";

	//Se remplaza el texto por el objeto INPUT
	obj.replaceChild(input, obj.firstChild);

	//Se selecciona el elemento y el texto a modificar
	input.focus();
	input.select();

	//Asignaci�n de los 2 eventos que provocar�n la escritura en la base de datos 

      //Salida de la INPUT
	input.onblur = function salir()
	{
		salvarMod(obj, input.value);
		delete input;
	};

	//La tecla Enter
	input.onkeydown = function keyDown(event)
	{
		if(event.keyCode == 13)
        {
			salvarMod(obj, input.value);
			delete input;
		}
	};
}


//Salvando las modificaciones
function salvarMod(obj, valor)
{
    obj.replaceChild(document.createTextNode(valor), obj.firstChild);
    // var i = obj.parentNode.parentNode.rowIndex;
   // var id = obj.previousSibling.value;
    request = new XMLHttpRequest();
    //request.onreadystatechange = responseElimina;
   // var id = obj.id;
    var id = obj.parentNode.lastChild.lastChild.value;
    //alert(id);
    var price = valor;
   // alert(price);
    //var id = obj.lastChild.value;
    //alert(id);
   // var dato = valor;
    
    request.open("GET","ModifyPrice?id=" + id + "&price=" + price, true);
    request.send(null);
    
}

function borrar(obj)
{
    var i = obj.parentNode.parentNode.rowIndex;
   // alert(i);
    var id = obj.parentNode.parentNode.lastChild.previousSibling.lastChild.value;
   // alert(id);
    document.getElementById('tabla-usuarios').deleteRow(i);
    
    request = new XMLHttpRequest();
    //request.onreadystatechange = responseElimina;
    request.open("GET","Elimina?id=" + id,true);
    request.send(null);
}

function agregar(){
    
    request = new XMLHttpRequest();
    request.onreadystatechange = function()
    {
        if(request.readyState==4){
            
            
    
           document.getElementById("tabla-usuarios").innerHTML += "<tr><td id='nombre' class='celda' ondblclick='modificar(this)'>" + "Jorge" + "</td>"
                            +  "<td id='apellido' class='celda' ondblclick='modificar(this)'>" + "Saldivar" + "</td>"
                            +  "<td id='direccion' class='celda' ondblclick='modificar(this)'>" + "calle" + "</td>"
                            +  "<td id='codigo' class='celda' ondblclick='modificar(this)'>" + "362" + "</td>"
                            +  "<td id='ciudad' class='celda' ondblclick='modificar(this)'>" + "Monterrey" + "</td>"
                            +  "<td id='hijos' class='celda' ondblclick='modificar(this)'>" + "0" + "</td>"
                            +  "<td id='email' class='celda' ondblclick='modificar(this)'>" + "a01033317@itesm.mx" + "</td>"
                            +  "<td id='id' class='celda' style='display:none;'><input type='hidden' value='" + request.responseText + "'/></td>"
                            +  "<td id='boton' class='celda'><input type='button' value='Borrar fila' onclick='borrar(this)'/></td></tr>";           
    
        }
    };
   request.open("GET","Inserta",true);
   request.send(null);
    
  

    
    
    //request = new XMLHttpRequest();
    //request.onreadystatechange = responseInserta;
    //request.open("GET","Inserta",true);
    //request.send(null);
}
