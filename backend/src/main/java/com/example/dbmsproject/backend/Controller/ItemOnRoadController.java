package com.example.dbmsproject.backend.Controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.dbmsproject.backend.Service.ItemOnRoadService;

import jakarta.validation.Valid;

import com.example.dbmsproject.backend.Model.ItemOnRoad;

@RestController
@RequestMapping("/api/itemonroads")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemOnRoadController {

    @Autowired
    private ItemOnRoadService itemOnRoadService;

    // C

    @PostMapping("/{userID}")
    public ResponseEntity<ItemOnRoad> createItemOnRoad(@Valid @RequestBody ItemOnRoad itemOnRoad,
            @PathVariable Long userID) {
        itemOnRoad.setUser(null);
        ItemOnRoad result = itemOnRoadService.saveItemOnRoad(itemOnRoad, userID);
        return ResponseEntity.ok().body(result);
    }
    // R
    /*
     * 查詢全部
     */

    @GetMapping("")
    public ResponseEntity<Collection<ItemOnRoad>> itemonroads() {
        Collection<ItemOnRoad> result = itemOnRoadService.getItemOnRoads();
        return ResponseEntity.ok().body(result);
    }
    /*
     * 依id查詢
     */

    @GetMapping("/id/{id}")
    public Optional<ItemOnRoad> getItemOnRoadById(@PathVariable Long id) {
        Optional<ItemOnRoad> item = itemOnRoadService.findById(id);
        return item;
    }
    /*
     * 依使用者查詢
     */

    @GetMapping("/user/{userID}")
    public ResponseEntity<Collection<ItemOnRoad>> getItemOnRoadsByUser(@PathVariable Long userID) {
        Collection<ItemOnRoad> result = itemOnRoadService.findByUser(userID);
        return ResponseEntity.ok().body(result);

    }

    /*
     * 依name查詢
     */

    @GetMapping("/name/{name}")
    public ResponseEntity<Collection<ItemOnRoad>> getItemOnRoadByName(@PathVariable String name) {
        Collection<ItemOnRoad> result = itemOnRoadService.findByName(name);
        return ResponseEntity.ok().body(result);
    }

    /*
     * 依type查詢
     */

    @GetMapping("/type/{type}")
    public ResponseEntity<Collection<ItemOnRoad>> getItemOnRoadByType(@PathVariable String type) {
        Collection<ItemOnRoad> result = itemOnRoadService.findByType(type);
        return ResponseEntity.ok().body(result);
    }

    /*
     * 依地點查詢
     */

    @GetMapping("/place/{placeName}")
    public ResponseEntity<Collection<ItemOnRoad>> getItemOnRoadByPlace(@PathVariable String placeName) {
        Collection<ItemOnRoad> result = itemOnRoadService.findByPlace(placeName);
        return ResponseEntity.ok().body(result);
    }

    // U

    @PutMapping("/{id}")
    public ResponseEntity<String> updateItemOnRoad(@PathVariable Long id, @Valid @RequestBody ItemOnRoad request) {
        boolean rlt = itemOnRoadService.updateItemOnRoad(id, request);
        if (!rlt) {
            return ResponseEntity.badRequest().body("錯誤");
        }
        return ResponseEntity.ok().body("成功更新物品");
    }

    // D

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        Boolean rlt = itemOnRoadService.deleteItemOnRoad(id);
        if (!rlt) {
            return ResponseEntity.badRequest().body("Id 不存在");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}
