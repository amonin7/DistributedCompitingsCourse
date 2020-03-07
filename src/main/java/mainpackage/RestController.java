package mainpackage;

import mainpackage.entities.GoodEntity;
import mainpackage.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

@Controller
public class RestController {

    @Autowired
    private GoodsRepository goodsRepository;

    @GetMapping("/getAllGoods")
    public @ResponseBody Iterable<GoodEntity> getAllGoods() {
        return goodsRepository.findAll();
    }

    @PostMapping("/addGood")
    public @ResponseBody String addGood(@RequestParam String name, @RequestParam BigInteger code, @RequestParam String category) {
        GoodEntity good = new GoodEntity(name, code, category);
        goodsRepository.save(good);
        return "Saved";
    }

    @DeleteMapping("/deleteGoodById")
    public @ResponseBody String deleteGood(@RequestParam Long id) {
        Optional<GoodEntity> good = goodsRepository.findById(id);
        if (good.isPresent()) {
            goodsRepository.delete( good.get() );
            return "Deleted";
        } else {
            return "There is no good with such id";
        }
    }

    @GetMapping("/getGoodById")
    public @ResponseBody GoodEntity getGood(@RequestParam Long id) {
        Optional<GoodEntity> good = goodsRepository.findById(id);
        return good.orElse(null);
    }

    @PostMapping("/editGood")
    public @ResponseBody String editGood(
            @RequestParam(name="id", required = false) Long id,
            @RequestParam(name="name", required = false) String name,
            @RequestParam(name="code", required = false) BigInteger code,
            @RequestParam(name="category", required = false) String category) {
        Optional<GoodEntity> good = goodsRepository.findById(id);
        if (good.isPresent()) {
            GoodEntity foundGood = good.get();
            goodsRepository.save(foundGood.updateGood(name, code, category));
            return "Updated";
        } else {
            return "There is no good with such id";
        }
    }

//    @PostMapping("/addGood2")
//    public @ResponseBody String addGood2(GoodEntity goodEntity) {
//        goodsRepository.save(goodEntity);
//        return "Saved";
//    }


}
