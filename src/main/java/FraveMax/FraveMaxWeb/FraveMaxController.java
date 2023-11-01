package FraveMax.FraveMaxWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FraveMaxController {
    @Autowired
    private TemplateEngine templateEngine;
    

//    @GetMapping("/producto")
//    public String Producto(Model model) {
//        ProductoData pd = new ProductoData();
//        Producto producto = pd.listarProducto(2);
//        model.addAttribute("producto", producto);
//        return "producto";
//    }

    @GetMapping("/producto/{productId}")
    public String Producto(@PathVariable int productId, Model model) {
        ProductoData pd = new ProductoData();
        Producto producto = pd.listarProducto(productId);
        model.addAttribute("producto", producto);
        return "producto";
    }

    @GetMapping("/ingresar")
    public String greetingForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "ingresar";
    }

    @PostMapping("/perfil")
    public String greetingSubmit(@ModelAttribute Usuario usuario, Model model) {
//        System.out.println(usuario.getUsuario()+" QQ");
//        System.out.println(usuario.getPass()+" KK");
        UsuarioData usuData = new UsuarioData();
        Usuario usu = usuData.listarUsuario(usuario.getUsuario()); //swap btn objects;
        model.addAttribute("usuario", usu);
        return "perfil";
    }

//    @GetMapping("/")
//    public String producto(Producto producto, Model model) {
//        model.addAttribute("usuario", new Usuario());
//        return "ingresar";
//    }
}
