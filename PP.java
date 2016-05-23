// PP.java

import java.util.*;

/*********/
/* Types */
/*********/

abstract class Type {}//Type

class Int extends Type {

    public String toString () {
        return "integer";
    }
}//Int

class Bool extends Type {

    public String toString () {
        return "boolean";
    }
}//Bool

class Array extends Type {

    Type elements;

    Array (Type elements) {
        this.elements = elements;
    }//Array

    public String toString () {
        return "array("+elements+")";
    }

}//Array

/**************************************/
/* Arithmetic and boolean expressions */
/**************************************/

abstract class PPExpr {
    abstract UPPExpr toUPP(Arraylist<string> locals);
}//PPExpr

class PPCte extends PPExpr {

    int val;

    PPCte (int val) {
        this.val = val;
    }//PPCte
    UPPexpr toUPP(ArrayList<String> locals){
        UPPExpr eq = e.toUPP(locals);
        return new UPPCte(eq);
    }
    public String toString () {
        return Integer.toString(val);
    }

}//PPCte

class PPTrue extends PPExpr {
    UPPExpr toUPP(Arraylist<string> locals)
    {
        return new UPPTrue();
    }
    public String toString () {
        return "true";
    }
}//PPTrue

class PPFalse extends PPExpr {
    UPPExpr toUPP(Arraylist<string> locals)
    {
        return new UPPFalse();
    }
    public String toString () {
        return "false";
    }
}//PPFalse

class PPVar extends PPExpr {

    String name;

    PPVar (String name) {
        this.name = name;
    }//PPVar
    UPPExpr toUPP(Arraylist<string> locals){
        if locals.contains(this.name){
            return UPPVar(this.name);
        }
        else{
            return UPPGVar(this.name);
        }
    }
    public String toString () {
        return name;
    }

}//PPVar

abstract class PPUnOp extends PPExpr {

    PPExpr e;

}//PPUnOp

class PPInv extends PPUnOp {

    PPInv (PPExpr e) {
        this.e = e;
    }//PPInv

    UPPexpr toUPP(ArrayList<String> locals){
        UPPExpr eq = e.toUPP(locals);
        return new UPPSub(new UPPCte(0), eq);
    }
    public String toString () {
        return "- (" + e + ")";
    }
}//PPInv

class PPNot extends PPUnOp {

    PPNot (PPExpr e) {
        this.e = e;
    }//PPNot
    UPPexpr toUPP(ArrayList<String> locals){
        UPPExpr eq = e.toUPP(locals);
        return new UPPNot(eq);
    }
    public String toString () {
        return "not ("+e+")";
    }

}//PPNot

abstract class PPBinOp extends PPExpr {

    PPExpr e1, e2;

}//PPBinOp

class PPAdd extends PPBinOp {

    PPAdd (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPAdd
    UPPExpr toUPP(Arraylist<string> locals)
    {
        UPPExpr eq1 = e1.toUPP(locals);
        UPPExpr eq2 = e2.toUPP(locals);
        return new UPPAdd(eq1, eq2);
    }
    public String toString() {
        return "+ (" + e1 + ") (" + e2 + ")";
    }
}//PPAd

class PPSub extends PPBinOp {

    PPSub (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPSub
    UPPExpr toUPP(Arraylist<string> locals){
        UPPExpr eq1 = e1.toUPP(locals);
        UPPExpr eq2 = e2.toUPP(locals);
        return new UPPSub(eq1, eq2);
    }
    public String toString() {
        return "- (" + e1 + ") (" + e2 + ")";
    }

}//PPSub

class PPMul extends PPBinOp {

    PPMul (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPMul
    UPPExpr toUPP(Arraylist<string> locals){
        UPPExpr eq1 = e1.toUPP(locals);
        UPPExpr eq2 = e2.toUPP(locals);
        return new UPPMul(eq1, eq2);
    }
    public String toString() {
        return "* (" + e1 + ") (" + e2 + ")";
    }

}//PPMul

class PPDiv extends PPBinOp {

    PPDiv (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPDiv
    UPPExpr toUPP(Arraylist<string> locals){
        UPPExpr eq1 = e1.toUPP(locals);
        UPPExpr eq2 = e2.toUPP(locals);
        return new UPPDiv(eq1, eq2);
    }

    public String toString() {
        return "/ (" + e1 + ") (" + e2 + ")";
    }
}//PPDiv

class PPAnd extends PPBinOp {

    PPAnd (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPAnd
    UPPExpr toUPP(Arraylist<string> locals)
    {
        UPPExpr eq1 = e1.UPPExpr();
        UPPExpr eq2 = e2.UPPExpr();
        return new(UPPAnd(eq1, eq2))
    }
    public String toString() {
        return "and (" + e1 + ") (" + e2 + ")";
    }
}//PPAnd

class PPOr extends PPBinOp {

    PPOr (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPOr
    UPPExpr toUPP(Arraylist<string> locals){
        UPPExpr eq1 = e1.toUPP(locals);
        UPPExpr eq2 = e2.toUPP(locals);
        return new UPPOr(eq1, eq2);
    }

    public String toString() {
        return "or (" + e1 + ") (" + e2 + ")";
    }
}//PPOr

class PPLe extends PPBinOp {

    PPLe (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPLe
    UPPExpr toUPP(Arraylist<string> locals){
        UPPExpr eq1 = e1.toUPP(locals);
        UPPExpr eq2 = e2.toUPP(locals);
        return new UPPLe(eq1, eq2);
    }
    public String toString() {
        return "< (" + e1 + ") (" + e2 + ")";
    }

}//PPLe

class PPLeq extends PPBinOp {

    PPLeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPLeq
    UPPExpr toUPP(Arraylist<string> locals){
        UPPExpr eq1 = e1.toUPP(locals);
        UPPExpr eq2 = e2.toUPP(locals);
        return new UPPLeq(eq1, eq2);
    }
    public String toString() {
        return "<= (" + e1 + ") (" + e2 + ")";
    }

}//PPLeq

class PPEq extends PPBinOp {

    PPEq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPEq
    UPPExpr toUPP(ArrayList<String> locals) {
        UPPExpr eq1 = e1.toUPP(locals);
        UPPExpr eq2 = e2.toUPP(locals);
        return new UPPEq(eq1, eq2);
    }//toUPP

    public String toString() {
        return "== (" + e1 + ") (" + e2 + ")";
    }

}//PPEq

class PPNeq extends PPBinOp {

    PPNeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPNeq
    UPPExpr toUPP(Arraylist<string> locals){
        UPPExpr eq1 = e1.toUPP(locals);
        UPPExpr eq2 = e2.toUPP(locals);
        return new UPPNeq(eq1, eq2);
    }
    public String toString() {
        return "!= (" + e1 + ") (" + e2 + ")";
    }

}//PPNeq

class PPGeq extends PPBinOp {

    PPGeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPGeq
    UPPExpr toUPP(Arraylist<string> locals){
        UPPExpr eq1 = e1.toUPP(locals);
        UPPExpr eq2 = e2.toUPP(locals);
        return new UPPGeq(eq1, eq2);
    }
    public String toString() {
        return ">= (" + e1 + ") (" + e2 + ")";
    }

}//PPGeq

class PPGe extends PPBinOp {

    PPGe (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPGe
    UPPExpr toUPP(Arraylist<string> locals){
        UPPExpr eq1 = e1.toUPP(locals);
        UPPExpr eq2 = e2.toUPP(locals);
        return new UPPGe(eq1, eq2);
    }
    public String toString() {
        return "> (" + e1 + ") (" + e2 + ")";
    }

}//PPGe

abstract class Callee {}//Callee

class Read extends Callee {}//Read

class Write extends Callee {}//Write

class User extends Callee {

    String name;

    User (String name) {
        this.name = name;
    }//User

}//User

class PPFunCall extends PPExpr {

    Callee callee;
    ArrayList<PPExpr> args;

    PPFunCall (Callee callee, ArrayList<PPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//FunCall

    public UPPFunCall toUPP(Arraylist<string> locals){
        Arraylist<UPPExpr> uargs = new Arraylist<>();
        for (PPExpr args : this.args){
            uargs.add(args.toUPP(locals));
        }
    return new UPPFunCall(Callee, uargs);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(callee);
        sb.append(" (");
        for (PPExpr arg : this.args) {
            sb.append(" (");
            sb.append(arg);
            sb.append(") ");
        }
        sb.append(") ");
        return sb.toString();
    }

}//FunCall

class PPArrayGet extends PPExpr {

    PPExpr arr, index;

    PPArrayGet (PPExpr arr, PPExpr index) {
        this.arr = arr;
        this.index = index;
    }//PPArrayGet
    public UPPExpr toUPP(ArrayList<String> locals) {
        UPPExpr uIndex = new UPPMul(new UPPCte(4), index.toUPP(locals));
        UPPExpr address = new UPPAdd(arr.toUPP(locals), uIndex);
        return new UPPLoad(address);
    }
    public String toString() {
        return arr + " (" + index + ")";
    }
}//PPArrayGet

class PPArrayAlloc extends PPExpr {

    Type type;
    PPExpr size;

    PPArrayAlloc (Type type, PPExpr size) {
        this.type = type;
        this.size = size;
    }//PPArrayAlloc
    public UPPExpr toUPP(ArrayList<String> locals) {
        ArrayList<UPPExpr> args = new ArrayList<UPPExpr>();
        UPPExpr tmp = new UPPMul(new UPPCte(4), size.toUPP(locals));
        args.add(tmp);
        return new UPPFunCall(new Alloc(), args);
    }
    public String toString() {
        return "new array (" + type + ") (" + size + ")";
    }

}//PPArrayAlloc

/****************/
/* Instructions */
/****************/

abstract class PPInst {
    public abstract UPPInst toUPP(Arraylist<String> locals);
}// PPInst

class PPAssign extends PPInst {

    String name;
    PPExpr val;

    PPAssign (String name, PPExpr val) {
        this.name = name;
        this.val = val;
    }//PPAssign
    public UPPAssign toUPP(Arraylist<string> locals){
        UPPExpr uval = val.toUPP(locals);
        return new UPPAssign(name, uval);
    }
    public String toString() {
        return "= (" + name + ") (" + val + ")";
    }
}//PPAssign

class PPArraySet extends PPInst {

    PPExpr arr, index, val;

    PPArraySet (PPExpr arr, PPExpr index, PPExpr val) {
        this.arr = arr;
        this.index = index;
        this.val = val;
    }//PPArraySet
    public UPPArraySet toUPP(Arraylist<string> locals){
        UPPExpr uval = val.toUPP(locals);
        UPPExpr uarr = arr.toUPP(locals);
        UPPExpr uindex = index.toUPP(locals);
        UPPExpr addr = new UPPAdd(uarr, new UPPMul(new UPPCte(4), uindex));
        return new UPPStore(addr, uval);
    }
    public String toString() {
        return "= (" + arr + " (" + index + ") ) (" + val + ")";
    }


}//PPArraySet

class PPCond extends PPInst {

    PPExpr cond;
    PPInst i1, i2;

    PPCond (PPExpr cond, PPInst i1, PPInst i2) {
        this.cond = cond;
        this.i1 = i1;
        this.i2 = i2;
    }//PPCond
    public UPPCond toUPP(ArrayList<String> locals) {
        ucond = this.cond.toUPP(locals);
        ui1 = this.i1.toUPP(locals);
        ui2 = this.i2.toUPP(locals);
        return new UPPCond(ucond, ui1, ui2);
    }
    public String toString() {
        return "if (" + cond + ") (" + i1 + ") (" + i2 + ")";
    }


}//PPCond

class PPWhile extends PPInst {

    PPExpr cond;
    PPInst i;

    PPWhile (PPExpr cond, PPInst i) {
        this.cond = cond;
        this.i = i;
    }//PPWhile
    public UPPWhile toUPP(Arraylist<String> locals){
        ucond = this.cond.toUPP(locals);
        ui = this.i.toUPP(locals);
        return new UPPWhile(ucond, ui);
    }
    public String toString() {
        return "while (" + cond + ") (" + i + ")";
    }

}//PPWhile

class PPProcCall extends PPInst {

    Callee callee;
    ArrayList<PPExpr> args;

    PPProcCall (Callee callee, ArrayList<PPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//PPProcCall
    public UPPCond toUPP(ArrayList<String> locals) {
        ArrayList<UPPExpr> uargs = new Arraylist<>();
        for (PPExpr arg : args) {
            uargs.add(arg.toUPP(locals));
        }
        return new UPPProcCall(this.callee, uargs);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(callee);
        sb.append(" (");
        for (PPExpr arg : this.args) {
            sb.append(" (");
            sb.append(arg);
            sb.append(") ");
        }
        sb.append(") ");
        return sb.toString();
    }


}//PPProcCall
    
class PPSkip extends PPInst {
    public UPPSkip toUPP(ArrayList<String> locals) {
        return new UPPSkip();
    }
    public String toString() {
        return "skip";
    }
}//PPSkip

class PPSeq extends PPInst {

    PPInst i1, i2;

    PPSeq (PPInst i1, PPInst i2) {
        this.i1 = i1;
        this.i2 = i2;
    }//PPSeq
    public UPPSeq toUPP(ArrayList<String> locals) {
        UPPInst ui1 = this.i1.toUPP(locals);
        UPPInst ui2 = this.i2.toUPP(locals);
        return new UPPSeq(ui1, ui2);
    }
    public String toString() {
        return "(" + i1 + ") (" + i2 + ")";
    }

}//PPSeq

/***************************************/
/* Definitions of functions/procedures */
/***************************************/

abstract class PPDef {

    String name;
    ArrayList<Pair<String,Type>> args, locals;
    PPInst code;
    public abstract UPPDef toUPP(ArrayList<String> locals);
}//PPDef

class PPFun extends PPDef {

    Type ret;

    PPFun (String name, ArrayList<Pair<String,Type>> args,
         ArrayList<Pair<String,Type>> locals, PPInst code, Type ret) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
        this.ret = ret;
    }//PPFun


    public UPPFun toUPP(ArrayList<String> locals) {
        ArrayList<String> uargs = new ArrayList<>();
        ArrayList<String> ulocals = new ArrayList<>();

        for (Pair<String, Type> arg : this.args) {
            uargs.add(arg.getLeft());
        }
        
        for (Pair<String, Type> local : this.locals) {
            ulocals.add(local.getLeft());
        }
        return new UPPFun(this.name, uargs, ulocals, this.code.toUPP(ulocals));
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" (");
        for (Pair<String, Type> arg : args) {
            sb.append(" (");
            sb.append(arg.left);
            sb.append(" ");
            sb.append(arg.right);
            sb.append(") ");
        }
        sb.append(")");
        sb.append(" (");
        sb.append(ret);
        sb.append(")");
        sb.append(" (");
        for (Pair<String, Type> local : locals) {
            sb.append(" (");
            sb.append(local.left);
            sb.append(" ");
            sb.append(local.right);
            sb.append(") ");
        }
        sb.append(")");
        sb.append(" (");
        sb.append(code);
        sb.append(")");
        return sb.toString();
    }

}//PPFun

class PPProc extends PPDef {

    PPProc (String name, ArrayList<Pair<String,Type>> args,
            ArrayList<Pair<String,Type>> locals, PPInst code) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
    }//PPProc
    public UPPProc toUPP(ArrayList<String> locals) {
        ArrayList<String> uargs = new ArrayList<>();
        ArrayList<String> ulocals = new ArrayList<>();

        for (Pair<String, Type> arg : this.args) {
            uargs.add(arg.getLeft());
        }
        
        for (Pair<String, Type> local : this.locals) {
            ulocals.add(local.getLeft());
        }

        return new UPPProc(this.name, uargs, ulocals, this.code.toUPP(ulocals));
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" (");
        for (Pair<String, Type> arg : args) {
            sb.append(" (");
            sb.append(arg.left);
            sb.append(" ");
            sb.append(arg.right);
            sb.append(")");
        }
        sb.append(")");
        sb.append(" (");
        for (Pair<String, Type> local : locals) {
            sb.append(" (");
            sb.append(local.left);
            sb.append(" ");
            sb.append(local.right);
            sb.append(") ");
        }
        sb.append(")");
        sb.append(" (");
        sb.append(code);
        sb.append(")");
        return sb.toString();
    }

}//PPProc

/************/
/* Programs */
/************/

class PPProg {

    ArrayList<Pair<String,Type>> globals;
    ArrayList<PPDef> defs;
    PPInst code;

    PPProg (ArrayList<Pair<String,Type>> globals, ArrayList<PPDef> defs,
          PPInst code) {
        this.globals = globals;
        this.defs = defs;
        this.code = code;
    }//PPProg

    public UPPProg toUPP() {
        ArrayList<String> uglobals = new ArrayList<>();
        ArrayList<UPPDef> udefs = new ArrayList<>();

        for (Pair<String, Type> global : this.globals) {
            uglobals.add(global.getLeft());
        }
        
        for (PPDef def : this.defs) {
            udefs.add(def.toUPP(new ArrayList<String>()));
        }

        return new UPPProg(uglobals, udefs, this.code.toUPP(new ArrayList<String>()));
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        sb.append("(");
        for (Pair<String, Type> vars : globals) {
            sb.append(" (");
            sb.append(vars.left);
            sb.append(" ");
            sb.append(vars.right);
            sb.append(") ");
        }
        sb.append(") ");

        sb.append("(");
        for (PPDef def : defs) {
            sb.append("(");
            sb.append(def);
            sb.append(")");
        }
        sb.append(") ");

        sb.append("(" + code + ")");

        sb.append(")");
        return sb.toString();
    }

}//PPProg