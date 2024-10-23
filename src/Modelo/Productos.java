
package Modelo;


public class Productos {
    private int id;
    private String codigo;
    private String nombre;
    private int proveedor;
    private String proveedorPro;
    private int stock;
    private double precio;
    
    private int medida;

    
    private int categoria;
    
    private String fecha_caducidad;
    private String fecha_compra;
    private int cajaId;
    
    public Productos(){
        
    }

    public Productos(int id, String codigo, String nombre, int proveedor, String proveedorPro, int stock, double precio,int medida, int categoria,String fecha_caducidad,String fecha_compra,int cajaId) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.proveedorPro = proveedorPro;
        this.stock = stock;
        this.precio = precio;
        this.medida = medida;
        this.categoria = categoria;
        this.fecha_caducidad = fecha_caducidad;
        this.fecha_compra = fecha_compra;
        this.cajaId = cajaId;
        
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getCajaId() {
        return cajaId;
    }

    public void setCajaId(int cajaId) {
        this.cajaId = cajaId;
    }
    

    public String getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public String getProveedorPro() {
        return proveedorPro;
    }

    public void setProveedorPro(String proveedorPro) {
        this.proveedorPro = proveedorPro;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getMedida() {
        return medida;
    }

    public void setMedida(int medida) {
        this.medida = medida;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

   
}
