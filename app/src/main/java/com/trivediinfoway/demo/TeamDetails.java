package com.trivediinfoway.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TeamDetails extends AppCompatActivity {

    String[] mumbai_indians = {"Rohit Sharma","Jasprit Bumrah","Rahul Chahar","Pat Cummins",
    "Hardik Pandya","Kieron Pollard","Krunal Pandya","Ishan Kishan","Mustafizur Rahman",
    "Aditya Tare","Evin Lewis","Jason Behrendorff","Akila Dananjaya","JP Duminy",
    "Anukul Roy","Tajinder Singh","Mohsin Khan","Mayank Markande","Pradeep Sangwan",
    "Suryakumar Yadav","Sharad Lumba","MD Nidheesh","Ben Cutting","Siddhesh Lad","Saurabh Tiwary"};
    String[] m_i_country = {"I","I","I","A","I","WI","I","I","B","I","WI","A","SL","SA",
    "I","I","I","I","I","I","I","I","A","I","I"};


    String[] chennai_super_kings_members = {"MS Dhoni","Suresh Raina","Ravindra Jadeja","Faf du Plessis",
    "Dwayne Bravo","Shane Watson","Kedar Jadhav","Harbhajan Singh","Mitchell Santner",
    "Shardul Thakur","Lungi Ngidi","Mark Wood","Murali Vijay","Asif KM","Sam Billings",
    "Karn Sharma","Ambati Rayudu","Jagadeeshan Narayan","Imran Tahir","Deepak Chahar",
    "Dhruv Shorey","Kshitiz Sharma","Chaitanya Bishnoi","Monu Kumar","Kanishk Seth"};
    String[] c_s_k_m_country = {"I","I","I","SA","WI","A","I","I","NZ","I","SA","E","I","I","E"
    ,"I","I","I","SA","I","I","I","I","I","I"};


    String[] kolkata_night_riders_members = {"Sunil Narine","Chris Lynn","Mitchell Starc",
    "Andre Russell","Dinesh Karthik","Robin Uthappa","Kuldeep Yadav","Piyush Chawla","Nitish Rana",
    "Kamlesh Nagarkoti","Shivam Mavi","Mitchell Johnson","Shubhman Gill","Vinay Kumar",
    "Rinku Singh","Javon Searless","Cameron Delport","Apoorv Wankhade","Ishank Jaggi"};
    String[] k_n_r_country = {"WI","A","A","WI","I","I","I","I","I","I","I","A","I","I","I",
    "WI","SA","I","I"};


    String[] sunrisers_hyderabad_members = {"David Warner","Manish Pandey","Rashid Khan",
    "Bhuvneshwar Kumar","Shikhar Dhawan","Wriddhiman Saha","Siddarth Kaul","Deepak Hooda",
    "Kane Williamson","Sandeep Sharma","Syed Khaleel Ahmed","Carlos Brathwaite","Shakib Al Hasan",
    "Yusuf Pathan","Mohammad Nabi","Chris Jordan","Shreevats Goswami","Basil Thampi","Billy Stanlake",
    "T Natarajan","Mehdi Hasan","Ricky Bhui","Tanmay Agarwal","Sachin Baby","Bipul Sharma"};
    String[] s_h_country = {"A","I","AF","I","I","I","I","I","NZ","I","I","I","B","I","AF","E","I","I","A",
            "I","I","I","I","I","I"};


    String[] delhi_daredevils_members = {"Prithvi Shaw","Colin Munro","Gautam Gamnbhir",
    "Abhishek Sharma","Trent Boult","Jason Roy","Kagiso Rabada","Naman Ojha","Glenn Maxwell",
    "Jayant Yadav","Harshal Patel","Amit Mishra","Manjot Karla","Vijay Shankar","Gurkeerat Singh",
    "Mohammed Shami","Rahul Tewatia","Daniel Christian","Aavesh Khan","Sayan Ghosh","Sandeep Lamichhane",
    "Chris Morris","Shreyas Iyer","Rishabh Pant","Shahbaz Nadeem"};
    String[] d_d_country = {"I","NZ","I","I","NZ","E","SA","I","A","I","I","I","I","I","I","I",
    "I","A","I","I","N","SA","I","I","I"};


    String[] royal_challengers_banglore = {"Virat Kohli","AB de Villiers","Brendon McCullum",
    "Sarfaraz Khan","Tim Southee","Chris Woakes","Moeen Ali","Colin de Grandhomme","Umesh Yadav",
    "Yuzvendra Chahal","Washington Sundar","Pawan Negi","Manan Vohra","Mandeep Singh",
    "Nathan Coulter-Nile","Quinton de Kock","Navdeep Saini","Mohammed Siraj","Pavan  Deshpande",
    "Aniruddha Joshi","Kulwant Khejroliya","Parthiv Patel","Murugan Ashwin","Aniket Chodhary"};
    String[] r_c_b_country = {"I","SA","NZ","I","NZ","E","E","NZ","I","I","I","I","I","I","A",
    "SA","I","I","I","I","SL","I","I","I"};


    String[] rajshthan_royals = {"Steven Smith","Ajinkya Rahane","Ben Stokes","Jos Buttler",
    "DA’rcy Short","Jefra Archer","Jaydev Unadkat","RahuL Tripathi","Ben Laughlin","Dhawal Kulkarni",
    "Stuart Binny","Aryaman Birla","Midhun S","Jatin Saxena","Shreyas Gopal","Anureet Singh",
    "Ankit Sharma","Krishnappa Gowtham","Sanju Samson","Prashant Chopra","Dushmantha Chameera",
    "Zahir Khan","Mahipal Lomror"};
    String[] r_r_country = {"A","I","E","E","A","WI","I","I","A","I","I","I","I","I","I",
            "I","I","I","I","I","SL","AF","I"};


    String[] king_punjab = {"Akshar Patel","KL RAHUL","Ravichandran Ashwin","Andrew Tye","MARCUS STOINIS",
    "Aaron Finch","Karun Nair","MUJEEB ZADRAN","David Miller","ANKIT RAJPOOT","Mohit Sharma",
    "Barinder Sran","YUVRAJ SINGH","Chris Gayle","Ben Dwarshuis","Mayank Agarwal",
    "Manoj Tiwary","Akshdeep Nath","Manzoor Dar","PRADEEP SAHU","Mayank Dagar"};
    String[] k_p_country = {"I","I","I","A","A","A","I","AF","SA","I","I","I","I","I","A",
    "I","I","I","I","I","I"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);
    }
}
