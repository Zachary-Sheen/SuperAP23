  class Assignment{
   name = "";
   quizTestHW = "";
   due = "";
   time = ""

     constructor(nom,qT,dueDate,time){
      //  console.log(nom);
      //   console.log(qT);
      //   console.log(dueDate);
        this.name = nom;
        this.quizTestHW = qT;
        this.due = dueDate;
        this.time = time;
      
     }

     name(){
        return this.name;
     }
     
     QTH(){
        return this.quizTestHW;
     }

     due(){
        return this.due;
     }
     time(){
        return this.time;
     }
  }
