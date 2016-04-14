package com.example.david_cohn.ezhear;


import android.content.Intent;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;


public class DiffPronounce extends ActionBarActivity {

    ArrayList<Pair> wordsList;
    Button leftButton;
    Button rightButton;
    CheckBox leftCheckBox;
    CheckBox rightCheckBox;

    Random randNum;
    TextToSpeech t1;

    int correctWordIndex;

    public class Pair<L,R> {

        private final L left;
        private final R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        public L getLeft() { return left; }
        public R getRight() { return right; }

        @Override
        public int hashCode() { return left.hashCode() ^ right.hashCode(); }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            Pair pairObject = (Pair) o;
            return this.left.equals(pairObject.getLeft()) &&
                    this.right.equals(pairObject.getRight());
        }

    }

    private void fillWords()
    {
        wordsList = new ArrayList<Pair>();

//        wordsList.add(new Pair("bin",   "bean"));
//        wordsList.add(new Pair("bitch",   "beach"));
//        wordsList.add(new Pair("chip",   "cheap"));
//        wordsList.add(new Pair("did",   "deed"));
//        wordsList.add(new Pair("fit",   "feet"));
//        wordsList.add(new Pair("grin",   "green"));
//        wordsList.add(new Pair("is",   "ease"));
//        wordsList.add(new Pair("it",   "eat"));
//        wordsList.add(new Pair("mitt",   "meet"));
//        wordsList.add(new Pair("sit",   "seat"));
//        wordsList.add(new Pair("slip",   "sleep"));
//        wordsList.add(new Pair("bit",   "beat"));
//        wordsList.add(new Pair("each",   "itch"));
//        wordsList.add(new Pair("fill",   "feel"));
//        wordsList.add(new Pair("hid",   "heed"));
//        wordsList.add(new Pair("hit",   "heat"));
//        wordsList.add(new Pair("ill",   "eel"));
//        wordsList.add(new Pair("kill",   "keel"));
//        wordsList.add(new Pair("kip",   "keep"));
//        wordsList.add(new Pair("lip",   "leap"));
//        wordsList.add(new Pair("mill",   "meal"));
//        wordsList.add(new Pair("pick",   "peek"));
//        wordsList.add(new Pair("piss",   "piece"));
//        wordsList.add(new Pair("pitch",   "peach"));
//        wordsList.add(new Pair("shill",   "she’ll"));
//        wordsList.add(new Pair("sick",   "seek"));
//        wordsList.add(new Pair("sin",   "seen"));
//        wordsList.add(new Pair("still",   "steal"));
//        wordsList.add(new Pair("chick",   "cheek"));
//        wordsList.add(new Pair("chit",   "cheat"));
//        wordsList.add(new Pair("dill",   "deal"));
//        wordsList.add(new Pair("gin",   "gene"));
//        wordsList.add(new Pair("grid",   "greed"));
//        wordsList.add(new Pair("hip",   "heap"));
//        wordsList.add(new Pair("kid",   "keyed"));
//        wordsList.add(new Pair("knit",   "neat"));
//        wordsList.add(new Pair("lick",   "leak"));
//        wordsList.add(new Pair("piss",   "peace"));
//        wordsList.add(new Pair("risen",   "reason"));
//        wordsList.add(new Pair("shit",   "sheet"));
//        wordsList.add(new Pair("sill",   "seal"));
//        wordsList.add(new Pair("sim",   "seem"));
//        wordsList.add(new Pair("sin",   "scene"));
//        wordsList.add(new Pair("still",   "steel"));
//        wordsList.add(new Pair("till",   "teal"));
//        wordsList.add(new Pair("tin",   "teen"));
//        wordsList.add(new Pair("tizz",   "teas"));
//        wordsList.add(new Pair("til",   "teal"));
//        wordsList.add(new Pair("bid",   "bead"));
//        wordsList.add(new Pair("bitch",   "beech"));
//        wordsList.add(new Pair("biz",   "bees"));
//        wordsList.add(new Pair("cist",   "ceased"));
//        wordsList.add(new Pair("dip",   "deep"));
//        wordsList.add(new Pair("fist",   "feast"));
//        wordsList.add(new Pair("fizz",   "fees"));
//        wordsList.add(new Pair("pill",   "peel"));
//        wordsList.add(new Pair("pip",   "peep"));
//        wordsList.add(new Pair("pit",   "peat"));
//        wordsList.add(new Pair("shin",   "sheen"));
//        wordsList.add(new Pair("skid",   "skied"));
//        wordsList.add(new Pair("skim",   "scheme"));
//        wordsList.add(new Pair("tick",   "teak"));
//        wordsList.add(new Pair("bib",   "Beeb"));
//        wordsList.add(new Pair("blip",   "bleep"));
//        wordsList.add(new Pair("britches",   "breeches"));
//        wordsList.add(new Pair("crick",   "creek"));
//        wordsList.add(new Pair("din",   "dean"));
//        wordsList.add(new Pair("finned",   "fiend"));
//        wordsList.add(new Pair("flit",   "fleet"));
//        wordsList.add(new Pair("gip",   "jeep"));
//        wordsList.add(new Pair("grist",   "greased"));
//        wordsList.add(new Pair("sim",   "seam"));
//        wordsList.add(new Pair("sip",   "seep"));
//        wordsList.add(new Pair("skit",   "skeet"));
//        wordsList.add(new Pair("slick",   "sleek"));
//        wordsList.add(new Pair("slit",   "sleet"));
//        wordsList.add(new Pair("tit",   "teat"));
//        wordsList.add(new Pair("tizz",   "tease"));



        wordsList.add(new Pair("dead",   "did"));
        wordsList.add(new Pair("desk",   "disk"));
        wordsList.add(new Pair("belt",   "built"));
        wordsList.add(new Pair("fell",   "fill"));
        wordsList.add(new Pair("head",   "hid"));
        wordsList.add(new Pair("left",   "lift"));
        wordsList.add(new Pair("mess",   "miss"));

        wordsList.add(new Pair("beg",   "big"));
        wordsList.add(new Pair("bell",   "bill"));
        wordsList.add(new Pair("bet",   "bit"));


        wordsList.add(new Pair("hell",   "hill"));

        wordsList.add(new Pair("let",   "lit"));

        wordsList.add(new Pair("set",   "sit"));


        wordsList.add(new Pair("tour",   "door"));
        wordsList.add(new Pair("town",   "down"));
        wordsList.add(new Pair("two",   "do"));
        wordsList.add(new Pair("tie",   "die"));
        wordsList.add(new Pair("ton",   "done"));
        wordsList.add(new Pair("too",   "do"));
        wordsList.add(new Pair("try",   "dry"));

        wordsList.add(new Pair("fan",   "van"));
        wordsList.add(new Pair("fast",   "vast"));
        wordsList.add(new Pair("fat",   "vat"));
        wordsList.add(new Pair("ferry",   "very"));



        wordsList.add(new Pair("leaf",   "leave"));
        wordsList.add(new Pair("off",   "of"));


        wordsList.add(new Pair("half",   "halve"));
        wordsList.add(new Pair("life",   "live"));
        wordsList.add(new Pair("proof",   "prove"));
        wordsList.add(new Pair("safe",   "save"));




//        wordsList.add(new Pair("bat", 		"but"));
//        wordsList.add(new Pair("batter", 	"butter"));
//        wordsList.add(new Pair("cap", 		"cup"));
//        wordsList.add(new Pair("cat", 		"cut"));
//        wordsList.add(new Pair("match", 	"much"));

//        wordsList.add(new Pair("bad", 		"bud"));
//        wordsList.add(new Pair("began", 	"begun"));
//        wordsList.add(new Pair("drank", 	"drunk"));
//        wordsList.add(new Pair("fan", 		"fun"));
//        wordsList.add(new Pair("hat", 		"hut"));
//        wordsList.add(new Pair("ran", 		"run"));
//        wordsList.add(new Pair("sang", 		"sung"));
//        wordsList.add(new Pair("swam", 		"swum"));

//        wordsList.add(new Pair("ankle", 	"uncle"));
//        wordsList.add(new Pair("back", 		"buck"));
//        wordsList.add(new Pair("badge", 	"budge"));
//        wordsList.add(new Pair("bag", 		"bug"));
//        wordsList.add(new Pair("ban", 		"bun"));
//        wordsList.add(new Pair("bank", 		"bunk"));
//        wordsList.add(new Pair("banker", 	"bunker"));
//        wordsList.add(new Pair("brash", 	"brush"));
//        wordsList.add(new Pair("cam", 		"come"));
//        wordsList.add(new Pair("crash", 	"crush"));
//        wordsList.add(new Pair("dabble", 	"double"));
//        wordsList.add(new Pair("dad", 		"dud"));
//        wordsList.add(new Pair("ham", 		"hum"));
//        wordsList.add(new Pair("hang", 		"hung"));
//        wordsList.add(new Pair("mad", 		"mud"));
//        wordsList.add(new Pair("massed", 	"must"));
//        wordsList.add(new Pair("pan", 		"pun"));
//        wordsList.add(new Pair("rang", 		"rung"));
//        wordsList.add(new Pair("rash", 		"rush"));
//        wordsList.add(new Pair("sack", 		"suck"));
//        wordsList.add(new Pair("sax", 		"sucks"));
//        wordsList.add(new Pair("stand", 	"stunned"));
//        wordsList.add(new Pair("track", 	"truck"));

//        wordsList.add(new Pair("bang",   "bung"));
//        wordsList.add(new Pair("cab",   "cub"));
//        wordsList.add(new Pair("cram",   "crumb"));
//        wordsList.add(new Pair("dam",   "dumb"));
//        wordsList.add(new Pair("damp",   "dump"));
//        wordsList.add(new Pair("dram",   "drum"));
//        wordsList.add(new Pair("fanned",   "fund"));
//        wordsList.add(new Pair("flash",   "flush"));
//        wordsList.add(new Pair("gnat",   "nut"));
//        wordsList.add(new Pair("hag",   "hug"));
//        wordsList.add(new Pair("paddle",   "puddle"));
//        wordsList.add(new Pair("pack",   "puck"));
//        wordsList.add(new Pair("pat",   "putt"));
//        wordsList.add(new Pair("rag",   "rug"));
//        wordsList.add(new Pair("sand",   "sunned"));
//        wordsList.add(new Pair("sank",   "sunk"));
//        wordsList.add(new Pair("scam",   "scum"));
//        wordsList.add(new Pair("slam",   "slum"));
//        wordsList.add(new Pair("slang",   "slung"));
//        wordsList.add(new Pair("stack",   "stuck"));
//        wordsList.add(new Pair("stank",   "stunk"));
//        wordsList.add(new Pair("tang",   "tongue"));
//        wordsList.add(new Pair("tag",   "tug"));
//        wordsList.add(new Pair("tramps",   "trumps"));
//        wordsList.add(new Pair("wan",   "won"));
//
//        wordsList.add(new Pair("blabber",   "blubber"));
//        wordsList.add(new Pair("champ",   "chump"));
//        wordsList.add(new Pair("dab",   "dub"));
//        wordsList.add(new Pair("dank",   "dunk"));
//        wordsList.add(new Pair("flank",   "flunk"));
//        wordsList.add(new Pair("flax",   "flux"));
//        wordsList.add(new Pair("gash",   "gush"));
//        wordsList.add(new Pair("glam",   "glum"));
//        wordsList.add(new Pair("grab",   "grub"));
//        wordsList.add(new Pair("hanker",   "hunker"));
//        wordsList.add(new Pair("hash",   "hush"));
//        wordsList.add(new Pair("hatch",   "hutch"));
//        wordsList.add(new Pair("jag",   "jug"));
//        wordsList.add(new Pair("lag",   "lug"));
//        wordsList.add(new Pair("mat",   "mutt"));
//        wordsList.add(new Pair("pap",   "pup"));
//        wordsList.add(new Pair("patter",   "putter"));
//        wordsList.add(new Pair("rabble",   "rubble"));
//        wordsList.add(new Pair("ram",   "rum"));
//        wordsList.add(new Pair("sally",   "sully"));
//        wordsList.add(new Pair("sap",   "sup"));
//        wordsList.add(new Pair("sapper",   "supper"));
//        wordsList.add(new Pair("scram",   "scrum"));
//        wordsList.add(new Pair("shacks",   "shucks"));
//        wordsList.add(new Pair("slag",   "slug"));
//        wordsList.add(new Pair("slash",   "slush"));
//        wordsList.add(new Pair("slat",   "slut"));
//        wordsList.add(new Pair("stab",   "stub"));
//        wordsList.add(new Pair("tab",   "tub"));
//        wordsList.add(new Pair("tack",   "tuck"));
//        wordsList.add(new Pair("tat",   "tut"));
//        wordsList.add(new Pair("thrash",   "thrush"));

//        wordsList.add(new Pair("bowl",   "ball"));
//        wordsList.add(new Pair("moaning",   "morning"));
//        wordsList.add(new Pair("mow",   "more"));
//        wordsList.add(new Pair("so",   "saw"));
//        wordsList.add(new Pair("boat",   "bought"));
//        wordsList.add(new Pair("close",   "claws"));
//        wordsList.add(new Pair("doze",   "doors"));
//        wordsList.add(new Pair("drone",   "drawn"));
//        wordsList.add(new Pair("foal",   "fall"));
//        wordsList.add(new Pair("folk",   "fork"));
//        wordsList.add(new Pair("note",   "nought"));
//        wordsList.add(new Pair("poke",   "pork"));
//        wordsList.add(new Pair("show",   "sure"));
//        wordsList.add(new Pair("shown",   "shorn"));
//        wordsList.add(new Pair("snow",   "snore"));
//        wordsList.add(new Pair("stow",   "store"));
//        wordsList.add(new Pair("tote",   "taught"));
//        wordsList.add(new Pair("chose",   "chores"));
//        wordsList.add(new Pair("coast",   "coursed"));
//        wordsList.add(new Pair("crow",   "craw"));
//        wordsList.add(new Pair("dome",   "dorm"));
//        wordsList.add(new Pair("goal",   "gall"));
//        wordsList.add(new Pair("know",   "no"));
//        wordsList.add(new Pair("low",   "law"));
//        wordsList.add(new Pair("motor",   "mortar"));
//        wordsList.add(new Pair("owe",   "or"));
//        wordsList.add(new Pair("toe",   "tour"));
//        wordsList.add(new Pair("tone",   "torn"));
//        wordsList.add(new Pair("code",   "cord"));
//        wordsList.add(new Pair("cone",   "corn"));
//        wordsList.add(new Pair("doze",   "doors"));
//        wordsList.add(new Pair("drone",   "drawn"));
//        wordsList.add(new Pair("foam",   "form"));
//        wordsList.add(new Pair("go",   "gore"));
//        wordsList.add(new Pair("hone",   "horn"));
//        wordsList.add(new Pair("load",   "lord"));
//        wordsList.add(new Pair("moan",   "mourn"));
//        wordsList.add(new Pair("moaning",   "morning"));
//        wordsList.add(new Pair("mow",   "more"));
//        wordsList.add(new Pair("oat",   "ought"));
//        wordsList.add(new Pair("owed",   "awed"));
//        wordsList.add(new Pair("poach",   "porch"));
//        wordsList.add(new Pair("quote",   "quart"));
//        wordsList.add(new Pair("show",   "shore"));
//        wordsList.add(new Pair("snow",   "snore"));
//        wordsList.add(new Pair("board",   "bored"));
//        wordsList.add(new Pair("choke",   "chalk"));
//        wordsList.add(new Pair("close",   "claws"));
//        wordsList.add(new Pair("coke",   "cork"));
//        wordsList.add(new Pair("copes",   "corpse"));
//        wordsList.add(new Pair("doe",   "door"));
//        wordsList.add(new Pair("flow",   "flaw"));
//        wordsList.add(new Pair("goad",   "gored"));
//        wordsList.add(new Pair("goal",   "gall"));
//        wordsList.add(new Pair("hoar",   "whore"));
//        wordsList.add(new Pair("hose",   "whores"));
//        wordsList.add(new Pair("implode",   "implored"));
//        wordsList.add(new Pair("joe",   "jaw"));
//        wordsList.add(new Pair("mole",   "maul"));
//        wordsList.add(new Pair("node",   "gnawed"));
//        wordsList.add(new Pair("scone",   "scorn"));
//        wordsList.add(new Pair("stoke",   "stork"));
//        wordsList.add(new Pair("stow",   "store"));
//        wordsList.add(new Pair("tote",   "taught"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_pronounce);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });

        randNum = new Random();
        randNum.setSeed(123456789);

        leftButton = (Button)findViewById(R.id.diffButtonLeft);
        rightButton = (Button)findViewById(R.id.diffButtonRight);

        leftCheckBox = (CheckBox)findViewById(R.id.leftCheckBox);
        rightCheckBox = (CheckBox)findViewById(R.id.rightCheckBox);

        fillWords();

        Collections.shuffle(wordsList);

        leftButton.setText((String)wordsList.get(0).getLeft());
        rightButton.setText((String)wordsList.get(0).getRight());

        leftCheckBox.setText((String)wordsList.get(0).getLeft());
        rightCheckBox.setText((String)wordsList.get(0).getRight());

    }


    public void leftButtonClick(View v) {
        String stringToSay = leftButton.getText().toString();
        t1.speak(stringToSay, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void rightButtonClick(View v) {
        String stringToSay = rightButton.getText().toString();
        t1.speak(stringToSay, TextToSpeech.QUEUE_FLUSH, null);
    }


    public void leftCheckBoxClick(View v) {
        if (leftCheckBox.isChecked()==true)
        {
            rightCheckBox.setChecked(false);

            Toast toast;
            View view;
            if (correctWordIndex == 0)
            {
                toast = Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT);
                view = toast.getView();

            }
            else
            {
                toast = Toast.makeText(this, "WRONG!", Toast.LENGTH_SHORT);
//                view = toast.getView();
//                view.setBackgroundResource(R.drawable.abc_btn_check_material);
            }

            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    public void rightCheckBoxClick(View v) {
        if (rightCheckBox.isChecked()==true)
        {
            leftCheckBox.setChecked(false);
        }

        Toast toast;
        View view;
        if (correctWordIndex == 1)
        {
            toast = Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT);
            view = toast.getView();

        }
        else
        {
            toast = Toast.makeText(this, "WRONG!", Toast.LENGTH_SHORT);
        }
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void saySomethingClick(View v) {
        int minVal = 0;
        int maxVal = 1;

//        correctWordIndex = randNum.nextInt(maxVal-minVal) + minVal;
        String wordToSay;
        if (Math.random() < 0.5) wordToSay=(String)wordsList.get(0).getLeft();
        else wordToSay=(String)wordsList.get(0).getRight();
        t1.speak(wordToSay, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void nextPairClick(View v) {
        Collections.shuffle(wordsList);

        leftButton.setText((String)wordsList.get(0).getLeft());
        rightButton.setText((String)wordsList.get(0).getRight());

        leftCheckBox.setText((String)wordsList.get(0).getLeft());
        rightCheckBox.setText((String)wordsList.get(0).getRight());

        leftCheckBox.setChecked(false);
        rightCheckBox.setChecked(false);



//        int minVal = 0;
//        int maxVal = wordsList.size();
//        int index = randNum.nextInt(maxVal-minVal) + minVal;
//        String wordToSay;
//        if (index==0) wordToSay=(String)wordsList.get(0).getLeft();
//        else wordToSay=(String)wordsList.get(0).getRight();
//        t1.speak(wordToSay, TextToSpeech.QUEUE_FLUSH, null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_diff_pronounce, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
