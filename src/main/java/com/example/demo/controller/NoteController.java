package com.example.demo.controller;

import com.example.demo.constant.TodoPagesConstant;
import com.example.demo.model.Note;
import com.example.demo.model.User;
import com.example.demo.service.NoteService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@EnableJpaAuditing
@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private UserService userService;


    @GetMapping("/viewNotes")
    public String viewNote(Model model,Principal principal){

        if (principal.getName()!=null){
            Optional<User> user= Optional.ofNullable(userService.getFindUsername(principal.getName()));
            if (user.isPresent()){
                model.addAttribute("username",user.get().getUsername());
                List<Note> notes=noteService.getAllNotesByUser(user.get().getId());
                model.addAttribute("notes",notes);
            }
        }else {
            model.addAttribute("notes",new ArrayList<Note>());
        }
        return TodoPagesConstant.NOTELIST;
    }

    @GetMapping("/add")
    public String add(){
        return TodoPagesConstant.ADDNOTE;
    }

    @PostMapping("/addNotes")
    public ResponseEntity<String> addNotes(@RequestBody Note note, Principal principal){
        User user= (userService.getFindUsername(principal.getName()));
        note.setUser(user);
        noteService.createNote(note);

        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @GetMapping("/getUpdate/{id}")
    public String getUpdate(@PathVariable("id") Long id, Model model){
        model.addAttribute("id",id);
        model.addAttribute("title",noteService.getNoteById(id).getTitle());
        model.addAttribute("content",noteService.getNoteById(id).getContent());

        return TodoPagesConstant.UPDATENOTE;

    }

    @PostMapping("/updateNote")
    public ResponseEntity<String> updateNotes(@RequestBody Note note,Principal principal){
        User user=(userService.getFindUsername(principal.getName()));
        note.setUser(user);
        noteService.createNote(note);

        return new ResponseEntity<>("OK", HttpStatus.CREATED);

    }

    @DeleteMapping("/deleteNote/{id}")
    @ResponseBody
    public String deleteNote(@PathVariable Long id){
        Note note  = noteService.getNoteById(id);
        noteService.deleteNote(note);

        return TodoPagesConstant.REGISTER;
    }

}



