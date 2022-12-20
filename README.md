# SocialMediaAppp

Functional Requirements :-

- Users can sign up on the app with email id / username and password


 1) Create User (SignUp)      POST          http://localhost:8080/signup
       {
        "name": "pavan",
	"email": "pavan@gmail.com",
         "mobileno" : "8421180837",
	"password": "Pavan@123"
       }


2) Login                     POST       http://localhost:8080/login
       {
        
	"email": "pavan@gmail.com",
	"password": "Pavan@123"
       }


==================================================================================
- Users can create posts and polls
 
1)Create new post                    POST       http://localhost:8080/newPost
       {
        "title": "Loving Nature",
	"description": "nature is the real beuty",
         "multimedianame" : "nature",
	 "multimediatype" : "Image/Video"
       }


2) Upload Photo/Video in Post        POST       http://localhost:8080/postmultimedia
 
      {
          file :   {upload Image or Video here}          //inHTML use multipart formdata
          name :  "samplevideo"
      }


3)Create new Poll                   POST           http://localhost:8080/newPoll/{userid}
      {
        "polltitle": "Who will win the match?"
	
       }

3) Add options to poll              POST           http://localhost:8080/addNewOption/{pollid}
        {
        "optioncontent": "India"
	
       }

========================================================================
 
- Users can view their feed comprising of posts and polls of other users

1) get post by userid          GET           http://localhost:8080/getPostById/{userid}



2) get post of all users       GET           http://localhost:8080/getAllPosts



3)get multimedia of post      
   
       for Image              GET             http://localhost:8080/getmultimediaVideo/{name}
       for Video              GET             http://localhost:8080/getmultimediaImage/{name}


2) get Options of Poll       GET             http://localhost:8080/getOptions/{pollid}
=======================================================================
- Support video and image sharing as well in posts


1) Upload Photo/Video in Post      POST       http://localhost:8080/postmultimedia
 
      {
          file :   {upload Image or Video here}          //inHTML use multipart formdata
          name :  "samplevideo"
      }

========================================================================

- Users can view the profile of another user and browse through their posts

1) All users                       GET         http://localhost:8080/getAllUsers

2) get User details for profile    GET         http://localhost:8080/getUser/{userid}

3)get post by userid               GET         http://localhost:8080/getPostById/{userid}


======================================================================
- Users can like and comment on posts/polls

1) Like the post                  GET        http://localhost:8080/likethepost/{postid}{userid}


2)Comment on Post                POST       http://localhost:8080/addNewComment/{userid}/{postid}

   {
        "content": "Nice Pic"
	
   }

3) Vote for Poll                GET         http://localhost:8080/voteTheOption/{optionid}/{userid}
========================================================================
- Include support for nested comments ( optional )





========================================================================
- Each post/poll should be displayed with the count of total likes and comments


1) Get Total likes of Post    GET              http://localhost:8080/getAllLikes/{postid}

2) Get Comments of Post       GET              http://localhost:8080/getComments/{postid}

3) Get Option Voters          GET              http://localhost:8080/getOptionVoters/{optionid}

=======================================================================
- Users can create/join groups and post content in groups

1) Create new group                  POST              http://localhost:8080/newgroup/{userid}

       {
        "groupname": "IT Job Alerts" , 
         "type"    : "Public/Private"         //use html dropdown for select	
      }


2) Join Group                        GET               http://localhost:8080/joingroup/{userid}/{groupid}


3) Create new post in group         POST       http://localhost:8080/postinGroup/{groupid}/{userid}
       {
        "title": "Loving Nature",
	"description": "nature is the real beuty",
         "multimedianame" : "nature",
	 "multimediatype" : "Image/Video"
       }


4) Upload Photo/Video in Post      POST       http://localhost:8080/postmultimedia
 
      {
          file :   {upload Image or Video here}          //inHTML use multipart formdata
          name :  "samplevideo"
      }

=======================================================================
- Groups maybe of 2 types - public and private

1) Create new group        POST              http://localhost:8080/newgroup/{userid}

  {
        "groupname": "IT Job Alerts" , 
         "type"    : "Public/Private"         //use html dropdown for select	
  }


=======================================================================
-Every group should be displayed with a count of its total members and total posts and
polls shared in it

1)Get Total likes of Post      GET              http://localhost:8080/getAllLikesGroup/{postid}


2)Get Total members of group   GET              http://localhost:8080/groupmembersCount/{groupid}



=======================================================================
-Only users who have joined a private group can view and like posts shared in that group

1) Get Posts of group       GET          http://localhost:8080/getGroupPosts/{groupid}/{userid}   //must be a member for Private group

2)Get Comments of Post       GET              http://localhost:8080/getCommentsGroup/{postid}

2) Like group post          GET          http://localhost:8080/liketheGrouppost/{postid}{userid}

3)Comment on Group Post       POST       http://localhost:8080/addNewCommentGroup/{userid}/{postid}
                                         
   {
        "content": "Nice Pic"
	
   }


=======================================================================
