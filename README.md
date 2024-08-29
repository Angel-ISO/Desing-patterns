<div aling="start">
tenemos 4 princpiales patrones a tocar durante este laboratorio, comenzaremos dando una contextualizacion y luego un ejemplo de la vida real donde yo considero que se podria aplicar.
</div>

## singleton

en clase vimos que es un patron creacional o anti patron que garantiza que una clase tenga una unica instancia global de acceso, un ejemplo de la vida real que yo creo que se podria aplicar es un calendario, desde donde accedamos siempre va a tener un mismo valor, en aplicaciones de tareas siempre es una practica añadir estos componentes.

![6eac9a76e0666296c012cfac4226f4c8.png](:/9de439d194af4fa6bfb5836ef4bfa3e3)

ejemplo de codigo

``` java
 package project.singleton;

public class Calendario {
    private static  Calendario instance = new Calendario("Miercoles");
    public String dia;
    public int año=2024;

    private Calendario(String valor){
        this.dia=valor;
    }

    // y aqui se puede acceder a la instancia de la clase
    public static Calendario getInstance(){
        return instance;
    }


}

```

y luego podemos acceder a la clase main para finalmente poder demostrar la instancia unica:


``` java
package project.singleton;

public class main {
    public static void main(String[] args) {
        System.out.println(Calendario.getInstance().dia);
        System.out.println(Calendario.getInstance().año);
        Calendario.getInstance().año=2025;
        System.out.println(Calendario.getInstance().año);
        Calendario.getInstance().dia="Jueves";
        System.out.println(Calendario.getInstance().dia);
    }
}

```

obtendremos el siguiente output
![d0ba93b3528d7cec5dadb7787f66583f.png](:/cfb94fdceff648e8aa0539ca887bf45f)

como podemos ver podemos modificar pero la instancia unica de la clase que creamos lo cual cumple con los requerimientos de singleton esto podria dar solucion cuando usamos clases globales, configuraciones de versiones, como podria ser el pom.xml en maven o los .sln en .net o el package.json en node que solo tienen una instancia unica a las dependencia y por medio de ellas accedemos a las dependencias donde las necesitemos en cualquier parte de nuestro proyecto.


## factory

este patron es creacional al igual que el singleton, este proporciona un interfaz para crear objetos en un super clase.Con otras palabras, el Factory Method define un método de una clase base que será la fábrica que se utilice para crear objetos, pero las subclases que hereden pueden proporcionar su propia implementación para crear objetos específicos. Un ejemplo podria ser tal vez una marca de moda que ofece distintos accesorios pero ellos pueden estar destinados a distintas partes del cuerpo, ya sea cabeza, cuello, tronco. etc

![78bfc8ca80c43d7322d2556a727994a5.png](:/b8e3360ed7244561ba2d7157f7def21c)

Ejemplo Codigo:


``` java
package project.Factory;

public interface Acessories {
    public void use();
}

```

clases que implementen la interfaz.
``` java
package project.Factory;

public class Gloves implements Acessories {
    @Override
    public void use() {
        System.out.println("Using gloves youre protecting your hands lil nigga");
    }
}

```

``` java
package project.Factory;

public class Hat implements Acessories {
    @Override
    public void use() {
        System.out.println("You are wearing a hat now u cant get sunburned");
    }
}

```

luego creamos una clase abstracta para definir un metodo por defecto para crear las clases, claramente el metodo debe ser del tipo de las clases:

``` java
package project.Factory;

public abstract class AcesoriesFactory {

    public abstract Acessories create();
}

```

```java
package project.Factory;

public class GlovesFactory extends AcesoriesFactory {
    @Override
    public Acessories create() {
        return new Gloves();
    }
}
```

```java
package project.Factory;

public class HatFactory extends AcesoriesFactory {

    @Override
    public Acessories create() {
        return new Hat();
    }
}
```

y finalmente podremos crear cada objeto.

``` java
package project.Factory;

public class Main {

    public static void main(String[] args) {
        AcesoriesFactory acesoriesFactory = new GlovesFactory();
        Acessories glove = acesoriesFactory.create();
        glove.use();

        AcesoriesFactory hatFactory = new HatFactory();
        Acessories hat = hatFactory.create();
        hat.use();

    }

}

```

y obtendremos la salida esperada en el metodo use que sobreescribimos en cada clase.

![f9a048056a1bb78f5882e90b67161b93.png](:/f01e35f168fa426aa1aebb39232cab3f)

este patron es una herramienta para manejar la creacion de objetos en aplicaciones donde los tipos de objetos a crear pueden variar. En lugar de codificar explicitamente la creacion de cada objeto, delegamos esta responsabilidad a las subclases especializadas, lo que nos permite mantener un codigo mas flexible y facil de extender.


## Facade

ya dejando de lado las patrones de diseño creacionales pasaremos a los patrones estructurales, pasaremos a este patron, normalmente lo usamos para usar una interfaz unificada, tratamos de simplificar la iteracion, podemos conseguir que los clientes no se compliquen entendiendo la complejidad interna. Un ejemplo podria ser un sistema de ventas o tienda, manejar, usuarios, compras y ventas, entregas. Pero como vimos debemos hacer esto lo mas sencillo posible para que el usuario tenga esto tan sencillo como realizar unos cuantos pasos sencillos.

![67925346c6c742ab29cbe9b5c48077c0.png](:/f445718fb92943e88a78162188bd868f)

ejemplo de codigo:


``` java
package project.Facade;

public class Inventory {

    public boolean isDisponible(String item) {
        System.out.println("Comprobacion de la disponibilidad para {" + item + "}");
        return true;
    }
}

```

```java
package project.Facade;

public class Payout {

    public void pay(int price) {
        System.out.println("Procesando Pago de {" + price + "}");
    }
}

```

```java
package project.Facade;

public class Delivery {

    public void deliver(String product) {
        System.out.println("el envio esta realizado con la entrega de {" + product + "}");
    }
}

```

apenas tenemos nuestros distintos servicios se puede proceder a implementarlos en un unico sistema o app

```java
package project.Facade;

public class FacadeRequest {
    private  Payout payout;
    private  Inventory inventory;
    private  Delivery delivery ;


    public FacadeRequest() {
        this.payout = new Payout();
        this.inventory = new Inventory();
        this.delivery = new Delivery();
    }

    public void dorequest(String item, int quantity) {
        if (inventory.isDisponible(item)) {
            System.out.println("Producto disponible, preparando pago");
            payout.pay(quantity);
            delivery.deliver(item);
        }
        else {
            System.out.println("No hay producto disponible");
        }
    }

}

```

y como podemos ver el metodo dorequest hace una agrupacion de todos los distintos metodos necesarios que necesitamos para que el usuario tenga todo en un solo lugar.


```java
package project.Facade;

public class Main {

    public static void main(String[] args) {
        FacadeRequest facadeRequest = new FacadeRequest();
        facadeRequest.dorequest("arroz", 10);
    }
}

```

ejemplo de la salida.

![cd52c1dbe4bd0218fc551e56deb7cbb2.png](:/997f8d39b148484cb86e916e11a07833)

como ya vimos este patron estructural puede ser bastante usado para las grandes compañias monolito complejas que al dia de hoy no se centran en solo tener un servicio a ofrecer sino tratar de poder amplificar sus servicios en todos los indoles como estamos viendo a meta trantando de seguir la vision de su creador para aproximarse al metaverso, todo junto en un solo lugar, o como roblox que tiene millones de experiencias en una unica plataforma, algo que estoy mas que seguro que en algun punto debieron usar facade.



## Strategy

este sin duda es el que considero mas cercano al chess debido a que este esta situado a poder aplicar distintos algoritmos y poder seleccionar alguno en tiempo de ejecucion. Un ejemplo podria ser las conversiones de descuentos a cada usuario.

![062229ab088837bafb7c4b2f75b24341.png](:/0199984f147545d4b57bc35f079c6dfc)

entonces comenzamos por una interfaz:

```java
package project.Strategy;

public interface Descount {
    public double getDiscount(double price);
}

```

y asignamos los descuentos que vamos a realizar implementando la interfaz:

```java
package project.Strategy;

public class TenDiscount implements Descount {
    @Override
    public double getDiscount(double price) {
        return price * 0.90; // 10% of discount applied
    }
}

```

```java
package project.Strategy;

public class FiveDollarsDiscount implements Descount {
    public double getDiscount(double price) {
        return price -5.0;  // 5$ of discount applied
    }
}

```

```java
package project.Strategy;

public class WithoutDiscount implements Descount {
    @Override
    public double getDiscount(double price) {
        return price; // no discount applied xDDDD
    }
}

```
luego creamos una clase que haga uso de un atributo descuento del tipo de la interfaz ya mencionada

```java
package project.Strategy;

public class Product {
    private String name;
    private double price;
    private Descount descount; 

    public Product( Descount descount) {
        this.descount = descount;
    }

    public double CalculateDiscount(double price) {
        return descount.getDiscount(price);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
```

y hacemos uso de la misma en el main y tendremos acceso a todos y cada uno de los descuentos y el metodo get discount se encargara de el resto.

```java
package project.Strategy;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(new TenDiscount());
        product.setName("pan");
        product.setPrice(100);
        System.out.println("decuento aplicado, el nuevo precio es \n$"+product.CalculateDiscount(100));

        product = new Product(new FiveDollarsDiscount());
        product.setName("pan");
        product.setPrice(100);
        System.out.println("decuento aplicado, el nuevo precio es \n$"+product.CalculateDiscount(100));

        product = new Product(new WithoutDiscount());
        product.setName("pan");
        product.setPrice(100);
        System.out.println("sin decuento, el nuevo precio es \n$"+product.CalculateDiscount(100));
    }
}

```

y obtendremos la siguiente salida:

![7460988faf7741624f68bdb342096251.png](:/ef45eff3a2844b8cb7edcda207047243)

esta interfaz ayuda a que podamos aplicar lo mismo con un distinto enfoque en este caso aplicando descuento, otro enfoque tambien podria ser en cuanto a las conversiones de moneda, las cuales son indispensables en plataformas de e ecomerce y donde es vital para poder ampliar el enfoque de la expansion de la app, un patron sumamente util.

<p align="center">
  <strong>Redactado y presentado por:</strong>
</p>

$$ angel gabriel ortega


para una documentacion mas legible porfavor leer el [patrones.pdf](/patrones%20de%20diseño-%20Angel%20Gabriel%20Ortega%20Corzo.pdf)https://github.com/Angel-ISO/Desing-patterns.git