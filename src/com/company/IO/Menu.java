package com.company.IO;

public class Menu {

    private String prompt;
    private String[] options;
    private String response;
    private int irange;

    public Menu(String prompt, String[] options, String response){
        this.prompt = prompt;
        this.options = options;
        this.response = response;
        //this.irange = this.options.size() + 1;
    }

    public void print_Options(){
        for (int i = 0; i < this.options.length; i++){
            System.out.println((i+1) + "." + this.options[i]);
        }
    }
}
