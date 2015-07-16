package in.hadron.leekuanyewquotes;

import android.app.ActionBar.LayoutParams;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class MainActivity extends ActionBarActivity {

    static String Quotes[] = {"<br><b>On Japan defeating colonial power Britain to occupy Singapore in 1942:</b><br><br>The dark ages had descended on us. It was brutal, cruel. In looking back, I think it was the biggest single political education of my life because, for three and a half years, I saw the meaning of power and how power and politics and government went together, and I also understood how people trapped in a power situation responded because they had to live. One day the British were there, immovable, complete masters; next day, the Japanese, whom we derided, mocked as short, stunted people with short-sighted squint eyes.<br>", "<b><br>The label of nanny state:</b><br><br>If Singapore is a nanny state, then I'm proud to have fostered one.<br>", "<b><br>On fostering relationships:</b><br><br>At the end of the day, what I cherish most are the human relationships. With the unfailing support of my wife and partner I have lived my life to the fullest. It is the friendships I made and the close family ties I nurtured that have provided me with that sense of satisfaction at a life well lived, and have made me what I am.<br>", "<b><br>PC? No way:</b><br><br>I always tried to be correct, not politically correct.<br>", "<b><br>Marriage advice:</b><br><br>So when the graduate man does not want to marry a graduate woman, I tell him he's a fool, stupid. You marry a non-graduate, you're going to have problems, some children bright, some not bright. You'll be tearing your hair out. you can't miss.<br>", "<b><br>On his legacy:</b><br><br>I'm no longer in active politics. It's irrelevant to me what young Singaporeans think of me. What they think of me after I'm dead and gone in one generation will be determined by researchers who do PhDs on me, right? So there will be a lot of revisionism. As people revised Stalin, Brezhnev and one day now Yeltsin, and later on Putin. I've lived long enough to know that you may be idealized in life and reviled after you're dead.<br>", "<b><br>On micromanagement:</b><br><br>I am often accused of interfering in the private lives of citizens. Yes, if I did not, had I not done that, we wouldn't be here today. And I say without the slightest remorse, that we wouldn't be here, we would not have made economic progress, if we had not intervened on very personal matters—who your neighbor is, how you live, the noise you make, how you spit, or what language you use. We decide what is right. Never mind what the people think.<br>", "<b><br>The eternal statesman:</b><br><br>Even from my sickbed, even if you are going to lower me into the grave and I feel that something is going wrong, I will get up. Those who believe that after I have left the government as prime minister, I will go into a permanent retirement really should have their heads examined.<br>", "<b><br>On VIRTUE:</b><br><br>Please remember we do not pretend to be virtuous.  Hypocrisy is not a feature of Singapore’s leadership.<br>", "<b><br>On COMMUNISM:</b><br><br>If I have to chose communism and anti-communism I will chose [sic] communism … if you hate something because you do not like some aspects of it, you can work yourself into a state where anything said and done by communists must be wrong and evil.<br>", "<b><br>During National Day Rally, 1990:</b><br><br>Every Singaporean who owns a flat can double his value in today’s terms within the next 15 to 20 years. In other words, in the next 20 years, we can make everybody worth twice as much, at least.<br>", "<b><br>On PROGRESS:</b><br><br>I am often accused of interfering in the private lives of citizens. Yes, if I did not, had I not done that, we wouldn’t be here today. And I say without the slightest remorse, that we wouldn’t be here, we would not have made economic progress, if we had not intervene on very personal matters – who your neighbour is, how you live, the noise you make, how you spit, or what language you use. We decide what is right. Never mind what people think.<br>", "<b><br>On PEACE:</b><br><br>Repression can only go up to a point. When it becomes too acute, the instruments of repression, namely the army and the police, have been proved time and time again in history to have turned their guns on their masters.<br>", "<b><br>On PEACE:</b><br><br>China can draw on a talent pool of 1.3 billion people, but the United States can draw on a talent pool of 7 billion and recombine them in a diverse culture that enhances creativity in a way that ethnic Han nationalism cannot.<br>", "<b><br>On PEACE:</b><br><br>If I tell Singaporeans – we are all equal regardless of race, language, religion, culture. Then they will say,”Look, I’m doing poorly. You are responsible.” But I can show that from British times, certain groups have always done poorly, in mathematics and in science. But I’m not God, I can’t change you. But I can encourage you, give you extra help to make you do, say maybe, 20% better.<br>", "<b><br>On PEACE:</b><br><br>I started off believing all men were equal. I now know that’s the most unlikely thing ever to have been, because millions of years have passed over evolution, people have scattered across the face of this earth, been isolated from each other, developed independently, had different intermixtures between races, peoples, climates, soils… I didn’t start off with that knowledge. But by observation, reading, watching, arguing, asking, that is the conclusion I’ve come to.<br>", "<b><br>On PEACE:</b><br><br>The Bell curve is a fact of life. The blacks on average score 85 per cent on IQ and it is accurate, nothing to do with culture. The whites score on average 100. Asians score more … the Bell curve authors put it at least 10 points higher. These are realities that, if you do not accept, will lead to frustration because you will be spending money on wrong assumptions and the results cannot follow.<br>", "<b><br>On PEACE:</b><br><br>There are some flaws in the assumptions made for democracy. It is assumed that all men and women are equal or should be equal. Hence, one-man-one-vote. But is equality realistic? If it is not, to insist on equality must lead to regression.<br>", "<b><br>On EQUALITY:</b><br><br>The successful, whether you’re a scholar, a Mandarin or a successful businessman or successful farmer, you had more than one wife. In fact you can have as many as your economic status entitles you or can persuade people to give their daughters up to you. In other words, the unsuccessful are like the weak lions or bucks in a herd, they were neutralised. So over the generations you must have the physically and the mentally more vibrant and vital, reproduce. We are doing just the opposite. We introduced monogamy. It seems so manifestly correct. The West was successful, superior. Why? Because they are monogamous. It was wrong. It was stupid.<br>", "<b><br>On EQUALITY:</b><br><br>If you don’t include your women graduates in your breeding pool and leave them on the shelf, you would end up a more stupid society…So what happens? There will be less bright people to support dumb people in the next generation. That’s a problem.<br>", "<b><br>On EQUALITY:</b><br><br>We must encourage those who earn less than $200 per month and cannot afford to nurture and educate many children never to have more than two… We will regret the time lost if we do not now take the first tentative steps towards correcting a trend which can leave our society with a large number of the physically, intellectually and culturally anaemic.<br>", "<b><br>On EQUALITY:</b><br><br>The human being is an unequal creature. That is a fact. And we start off with the proposition. All the great religions, all the great movements, all the great political ideology, say let us make the human being as equal as possible. In fact, he is not equal, never will be.<br>", "<b><br>On EQUALITY:</b><br><br>It is essential to rear a generation at the very top of society that has all the qualities needed to lead and give the people the inspiration and the drive to make it succeed. In short, the elite.. Every society tries to produce this type. The British have special schools for them: the gifted and talented are sent to Eton and Harrow.<br>", "<b><br>On MEDIA BIAS:</b><br><br>I pointed to an article with bold headlines reporting that the police had refused to allow the PAP to hold a rally at Empress Place, and then to the last paragraph where in small type it added the meeting would take place where we were now. I compared this with a prominent report about an SPA rally. This was flagrant bias.<br>", "<b><br>On FREEDOM:</b><br><br>My colleagues and I are of that generation of young men who went through the Second World War and the Japanese Occupation and emerged determined that no one–neither Japanese nor British–had the right to push and kick us around.  We determined that we could govern ourselves and bring up our children in a country where we can be proud to be self-respecting people.<br>", "<b><br>On FREEDOM:</b><br><br>Let us get down to fundamentals. Is this an open, or is this a closed society? Is it a society where men can preach ideas – novel, unorthodox, heresies, to established churches and established governments – where there is a constant contest for men’s hearts and minds on the basis of what is right, of what is just, of what is in the national interests, or is it a closed society where the mass media – the newspapers, the journals, publications, TV, radio – either bound by sound or by sight, or both sound and sight, men’s minds are fed with a constant drone of sycophantic support for a particular orthodox political philosophy? I am talking of the principle of the open society, the open debate, ideas, not intimidation, persuasion not coercion…<br>", "<b><br>On FREEDOM:</b><br><br>Any time, every time, you can damn the Prime Minister and so long as it is not a lie and a criminal lie, nothing happens to you.  You can say a lot of things.  You can write books about him, damning him.  So long as it is not a libel, go ahead<br>", "<b><br>On FREEDOM:</b><br><br>I am often accused of interfering in the private lives of citizens. Yes, if I did not, had I not done that, we wouldn’t be here today. And I say without the slightest remorse, that we wouldn’t be here, we would not have made economic progress, if we had not intervened on very personal matters – who your neighbour is, how you live, the noise you make, how you spit, or what language you use. We decide what is right. Never mind what the people think.<br>", "<b><br>On FREEDOM:</b><br><br>There is nothing to forbid anybody from nailing his colours to the mast, and indeed it is the safest way to do it. Nail your colours to the mast, defend it and say,”This is my flag, this is what I believe in. I believe in open debate, arguments, persuasion, I hope to win by votes.” But start manipulating innocent professional groups, cultural groups and make them support political causes, whether its freedom of the foreign press or whatever, then I say you are looking for unpleasant linkages with what has happened in the past.<br>", "<b><br>On FREEDOM:</b><br><br>The ideas of individual supremacy and the right of free expression, when carried to excess, have not worked. They have made it difficult to keep America society cohesive. Asia can see it is not working.. In America itself, there is widespread crime and violence, old people feel forgotten, families are falling apart. And the media attacks the integrity and character of your leaders with impunity, drags down all those in authority and blames everyone but itself<br>", "<b><br>On JUSTICE:</b><br><br>…you attack only those whom your Special Branch can definitely say are communists.  Then you attack those whom your Special Branch says are aiding communists.  Then finally, when you have gone that far, you attack all who oppose you.<i>-as an opposition PAP member speaking to David Marshall.4 October, 1956</i><br>", "<b><br>On JUSTICE:</b><br><br>These powers will not be allowed to be used against political opponents within the system who compete for the right to work the system. That is fundamental and basic or the powers will have destroyed the purpose for which they were forged<br>", "<b><br>On JUSTICE:</b><br><br>I can only express the hope that faith in the judicial system will never be diminished, and I am sure it will not, so long as we allow a review of the judicial processes that takes place here in some other tribunal where obviously undue influence cannot be brought to bear. As long as governments are wise enough to leave alone the rights of appeal to some superior body outside Singapore, then there must be a higher degree of confidence in the integrity of our judicial process. This is most important<br>", "<b><br>On JUSTICE:</b><br><br>We have over a hundred political detainees, men against whom we are unable to prove anything in a court of law. Nearly 50 of them are men who gave us a great deal of anxiety during the years of Confrontation because they were Malay extremists. Your life and this dinner would not be what it is if my colleagues and I had decided to play it according to the rules of the game<br>", "<b><br>On JUSTICE:</b><br><br>The same law applies to me. Nobody has sued me for libel because I do not defame my enemies<br>", "<b><br>On JUSTICE:</b><br><br>We have to lock up people, without trial, whether they are communists, whether they are language chauvinists, whether they are religious extremists. If you don’t do that, the country would be in ruins.<br>", "<b><br>On JUSTICE:</b><br><br>It is not the practice, now will I allow subversives to get away by insisting that I’ve got to prove everything against them in a court of law or [produce] evidence that will stand up to the strict rules of evidence of a court of law<br>", "<b><br>On JUSTICE:</b><br><br>Most libels, and I have taken about 30 actions, take place at election time. It has not stuck because I am prepared to go before a court, stand in the witness box and face the most aggressive of lawyers who can cross-examine me on my personal history.<br>", "<b><br>On DEMOCRACY:</b><br><br>But we either believe in democracy or we not. If we do, then, we must say categorically, without qualification, that no restraint from the any democratic processes, other than by the ordinary law of the land, should be allowed… If you believe in democracy, you must believe in it unconditionally. If you believe that men should be free, then, they should have the right of free association, of free speech, of free publication. Then, no law should permit those democratic processes to be set at nought.<i>-as an opposition leader, April 27, 1955</i><br>", "<b><br>On DEMOCRACY:</b><br><br>If it is not totalitarian to arrest a man and detain him, when you cannot charge him with any offence against any written law – if that is not what we have always cried out against in Fascist states – then what is it?… If we are to survive as a free democracy, then we must be prepared, in principle, to concede to our enemies – even those who do not subscribe to our views – as much constitutional rights as you concede yourself.<i>- Opposition leader Lee Kuan Yew, Legislative Assembly Debates, Sept 21, 1955</i><br>", "<b><br>On DEMOCRACY:</b><br><br>If we say that we believe in democracy, if we say that the fabric of a democratic society is one which allows for the free play of idea…then, in the name of all the gods, give that free play a chance to work within the constitutional framework.<i>– Opposition leader Lee Kuan Yew, Singapore Legislative Assembly, Oct 4, 1956</i><br>", "<b><br>On DEMOCRACY:</b><br><br>If I were in authority in Singapore indefinitely without having to ask those who are governed whether they like what is being done, then I would not have the slightest doubt that I could govern much more effectively in their interests.<br>", "<b><br>On DEMOCRACY:</b><br><br>I make no apologies that the PAP is the Government and the Government is the PAP.<i>- Petir, 1982</i><br>", "<b><br>On DEMOCRACY:</b><br><br>One-man-one-vote is a most difficult form of government.. Results can be erratic.<br>", "<b><br>On DEMOCRACY:</b><br><br>What are our priorities? First, the welfare, the survival of the people. Then, democratic norms and processes which from time to time we have to suspend.<br>", "<b><br>On DEMOCRACY:</b><br><br>If you are a troublemaker…it’s our job to politically destroy you. Put it this way. As long as JB Jeyaretnam stands for what he stands for – a thoroughly destructive force – we will knock him. Everybody knows that in my bag I have a hatchet, and a very sharp one. You take me on, I take my hatchet, we meet in the cul-de-sac.<br>", "<b><br>On DEMOCRACY:</b><br><br>I think in Singapore, we stand a chance of making the one-man-one-vote system work. With amendments as we have done, you know, like GRCs.. We need to make it work. And I believe with pragmatic adjustments, given these favourable conditions, we can have more open debate.<br>", "<b><br>On DEMOCRACY:</b><br><br>I feel sanguine enough to say that there has never been a better set of conditions for open democratic politics because there is no need for unified front politics.<br>", "<b><br>On DEMOCRACY:</b><br><br>I am encouraged also because I see more and more people write letters to the press and sign their real names. That’s a good sign, a good tendency. To run a democratic system, you must have democratic impulses in the people. There must be a cultural basis for that system. It’s not just having a constitution and saying,” Well, there you are, the system is democratic.<br>", "<b><br>On DEMOCRACY:</b><br><br>Now if democracy will not work for the Russians, a white Christian people, can we assume that it will naturally work with Asians?<br>", "<b><br>On DEMOCRACY:</b><br><br>With few exceptions, democracy has not brought good government to new developing countries…What Asians value may not necessarily be what Americans or Europeans value. Westerners value the freedoms and liberties of the individual. As an Asian of Chinese cultural backround, my values are for a government which is honest, effective and efficient.<br>", "<b><br>On DEMOCRACY:</b><br><br>I’m not intellectually convinced that one-man-one-vote is the best. We practise it because that’s what the British bequeathed us.<br>", "<b><br>On DEMOCRACY:</b><br><br>Anybody who decides to take me on needs to put on knuckle-dusters. If you think you can hurt me more than I can hurt you, try. There is no way you can govern a Chinese society.<br>", "<b><br>On DEMOCRACY:</b><br><br>You’re talking about Rwanda or Bangladesh, or Cambodia, or the Philippines. They’ve got democracy, according to Freedom House. But have you got a civilised life to lead? People want economic development first and foremost. The leaders may talk something else. You take a poll of any people. What is it they want? The right to write an editorial as you like? They want homes, medicine, jobs, schools.<br>", "<b><br>On DEMOCRACY:</b><br><br>They say people can think for themselves? Do you honestly believe that the chap who can’t pass primary six knows the consequence of his choice when he answers a question viscerally, on language, culture and religion? But we knew the consequences. We would starve, we would have race riots. We would disintegrate.<br>", "<b><br>On DEMOCRACY:</b><br><br>If we had considered them serious political figures, we would not have kept them politically alive for so long. We could have bankrupt them earlier.<br>", "<b><br>On DEMOCRACY:</b><br><br>Political reform need not go hand in hand with economic liberalisation.. I hold unconventional views about this.. I do not believe if you are a libertarian, full of diverse opinions, full of competing ideas in the market place, full of sound and fury, therefore you will succeed.<br>", "<b><br>On DEMOCRACY:</b><br><br>There is nothing to prevent you from pushing your propaganda, to push your programme out to the students or with the public at large…and if you can carry the ground, if you are right, you win. That’s democracy.<br>", "<b><br>On DEMOCRACY:</b><br><br>Please do not assume that you can change governments. Young people don’t understand this<br>", "<b><br>On DEMOCRACY:</b><br><br>They say, oh, let’s have multiparty politics. Let’s have different parties change and be in charge of the Government. Is it that simple? You vote in a Division Three government, not a Division One government, and the whole economy will just subside within three, four years. Finished.<br>", "<br>That was the year the British decided to get out and sell everything. So I immediately held an election. I knew the people will be dead scared. And I won my bet big-time.<i>On winning 88% of the votes in 1968</i><br>", "<br>At the end of the day, we are so many digits in the machine. The point is – are these digits stronger than the competitors' digits?<br>", "<br>Political reform need not go hand in hand with economic liberalisation. I do not believe that if you are libertarian, full of diverse opinions, full of competing ideas in the market place, full of sound and fury, therefore you will succeed.<br>", "<br>He picked up from me a certain way of thinking, certain logic, certain cut of mind. He has got from his mother a facility with words, and a certain intuition. So please do give him some slack, if you find that he thinks slowly, and speaks even more slowly.<i>-Lee Hsien Loong, Straits Times, Jun 22, 2004</i><br>", "<br>I ignore polling as a method of government. I think that shows a certain weakness of mind - an inability to chart a course whichever way the wind blows, whichever way the media encourages the people to go, you follow. If you can't force or are unwilling to force your people to follow you, with or without threats, you are not a leader.<br>", "<br>If, for instance, you put in a Malay officer who's very religious and who has family ties in Malaysia in charge of a machine gun unit, that's a very tricky business. We've got to know his background... I'm saying these things because they are real, and if I don't think that, and I think even if today the Prime Minister doesn't think carefully about this, we could have a tragedy.<i>- on Malays in the Singapore Armed Forces</i><br>", "<br>What people mean by consultation is an imitation of what they see in America; pressure groups and lobby groups..It's an unthinking adoption of Western practices of development without any pruning and modification to suit our circumstances.<br>", "<br>Supposing I'm now 21, 22, what would I do? I would not be absorbed in wanting to change life in Singapore. I'm not responsible for Singapore...Why should I go and undertake this job and spend my whole life pushing this for a lot of people for whom nothing is good enough? I will have a fall-back position, which many are doing - have a house in Perth or Vancouver or Sydney, or an apartment in London, in case I need some place suddenly, and think about whether I go on to America.<br>", "<br>Supposing Catherine Lim was writing about me and not the prime minister...She would not dare, right? Because my posture, my response has been such that nobody doubts that if you take me on, I will put on knuckle-dusters and catch you in a cul de sac...Anybody who decides to take me on needs to put on knuckle dusters. If you think you can hurt me more than I can hurt you, try. There is no other way you can govern a Chinese society.<br>", "<br>Mine is a very matter-of-fact approach to the problem. If you can select a population and they're educated and they're properly brought up, then you don't have to use too much of the stick because they would already have been trained. It's like with dogs. You train it in a proper way from small. It will know that it's got to leave, go outside to pee and to defecate. No, we are not that kind of society. We had to train adult dogs who even today deliberately urinate in the lifts.<br>", "<br>I have never been over concerned or obsessed with opinion polls or popularity polls. I think a leader who is, is a weak leader. Between being loved and being feared, I have always believed Machiavelli was right. If nobody is afraid of me, I’m meaningless.<br>", "<br>I have said this on many a previous occasion: that had the mix in Singapore been different, had it been 75% Indians, 15% Malays and the rest Chinese, it would not have worked. Because they believe in the politics of contention, of opposition. But because the culture was such that the populace sought a practical way out of their difficulties, therefore it has worked.<br>", "<br>(Without the CPF), Singaporeans would buy enormous quantities of clothes, shoes, furniture, television sets, radio, tape recorders, hi-fis, washing machines, motor cars. They would have no substantial or permanent asset to show for it.<br>", "<br>Freedom of the press, freedom of the news media, must be subordinated to the overriding needs of the integrity of Singapore, and to the primacy of purpose of an elected government.<br>", "<br>If we are to survive as a free democracy, then we must be prepared, in principle, to concede to our enemies — even those who do not subscribe to our views — as much constitutional rights as you concede yourself.<br>", "<br>If it is not totalitarian to arrest a man and detain him, when you cannot charge him with any offence against any written law — if that is not what we have always cried out against in Fascist states — then what is it?<br>", "<br>The task of the leaders must be to provide or create for them a strong framework within which they can learn, work hard, be productive and be rewarded accordingly. And this is not easy to achieve.<br>", "<br>If Mr Mah is unable to defend himself, he deserves to lose. No country in the world has given its citizens an asset as valuable as what we've given every family here. And if you say that policy is at fault, you must be daft. - when asked about a Straits Times report that cited keen opposition interest in contesting Tampines GRC, which National Development Minister Mah Bow Tan helms, so that they can raise the affordability of public housing as an election issue.<br>", "<br>When you're Singapore's leader and your existence depends on performance - extraordinary performance, better than your competitors - when that performance disappears because the system on which it's been based becomes eroded, then you've lost everything... I try to tell the younger generation that and they say the old man is playing the same record, we've heard it all before. I happen to know how we got here and I know how we can unscramble it. - On one freak election result ruining Singapore.<br>", "<br>If, for instance, you put in a Malay officer who's very religious and who has family ties in Malaysia in charge of a machine gun unit, that's a very tricky business. We've got to know his background... I'm saying these things because they are real, and if I don't think that, and I think even if today the Prime Minister doesn't think carefully about this, I and my family could have a tragedy.<br>", "<br>You know, the cure for all this talk is really a good dose of incompetent government. You get that alternative and you'll never put Singapore together again: Humpty Dumpty cannot be put together again... my asset values will disappear, my apartments will be worth a fraction of what they were, my ministers' jobs will be in peril, their security will be at risk and their women will become maids in other people's countries, foreign workers. I cannot have that! - Justifying million-dollar pay hike for Singapore ministers.<br>", "<br>That was the year the British decided to get out and sell everything. So I immediately held an election. I knew the people will be dead scared. And I won my bet big-time. The gullible fools!<br>", "<br><br>Political reform need not go hand in hand with economic liberalisation. I do not believe that if you are libertarian, full of diverse opinions, full of competing ideas in the market place, full of sound and fury, therefore you will succeed.<br>", "<br>I started off believing all men were equal. I now know that's the most unlikely thing ever to have been, because millions of years have passed over evolution, people have scattered across the face of this earth, been isolated from each other, developed independently, had different intermixtures between races, peoples, climates, soils... I didn't start off with that knowledge. But by observation, reading, watching, arguing, asking, and then bullying my way to the top, that is the conclusion I've come to.<br>", "<br>Mine is a very matter-of-fact approach to the problem. If you can select a population and they're educated and they're properly brought up, then you don't have to use too much of the stick because they would already have been trained. It's like with dogs. You train it in a proper way from small. It will know that it's got to leave, go outside to pee and to defecate. No, we are not that kind of society. We had to train adult dogs who even today deliberately urinate in the lifts.<br>", "<br>To straddle the middle ground and win elections, we have to be in charge of the political agenda. This can only be done by not being beaten in the argument with our critics. They complain that I come down too hard on their arguments. But wrong ideas have to be challenged before they influence public opinion and make for problems. Those who try to be clever at the expense of the government should not complain if my replies are as sharp as their criticisms.<br>", "<br>I ignore polling as a method of government. I think that shows a certain weakness of mind - an inability to chart a course whichever way the wind blows, whichever way the media encourages the people to go, you follow. If you can't force or are unwilling to force your people to follow you, with or without threats, you are not a leader.<br>", "<br>I am often accused of interfering in the private lives of citizens. Yes, if I did not, had I not done that, we wouldn't be here today. And I say without the slightest remorse, that we wouldn't be here, we would not have made economic progress, if we had not intervened on very personal matters - who your neighbour is, how you live, the noise you make, how you spit, or what language you use. We decide what is right. Never mind what the people think.<br>", "<br>The regret is there's such a narrow base to build this enormous edifice, so I've got to tell the next generation, please do not take for granted what's been built.If you forget that this is a small island which we are built upon and reach a 100 storeys-high tower block and may go up to 150 if you are wise. But if you believe that it's permanent, it will come tumbling down and you will never get a second chance.<br>", "<br>The final verdict will not be in the obituaries. The final verdict will be when the PhD students dig out the archives, read my old papers, assess what my enemies have said, sift the evidence and seek the truth.I'm not saying that everything I did was right, but everything I did was for an honourable purpose.<br>", "<br>We knew that if we were just like our neighbours, we would die. Because we've got nothing to offer against what they have to offer. So we had to produce something which is different and better than what they have. It's incorrupt. It's efficient. It's meritocratic. It works.We are pragmatists... Does it work? Let's try it and if it does work, fine, let's continue it. If it doesn't work, toss it out, try another one. We are not enamoured with any ideology.<br>", "<br>Let me be frank; if we did not have the good points of the West to guide us, we wouldn't have got out of our backwardness. We would have been a backward economy with a backward society. But we do not want all of the West.<br>", "<b><br>Others on LEE KUAN YEW:</b><br><br>Lee is like a banana –yellow of skin, white underneath.<i>-Zhou Enlai, Premier of the People’s Republic of China, at the Bandung Conference (1955)</i><br>", "<b><br>Others on LEE KUAN YEW:</b><br><br>More like a Hitler or Mussolini but with less polish and skill<i>- Socialist Front on Lee Kuan Yew, Malay Mail, March 28, 1964</i><br>", "<b><br>Others on LEE KUAN YEW:</b><br><br>A chameleon, a remarkable creature which can adjust its colour to its surroundings.<i>- Tan Siew Sin, Malaysian Chinese Association, in Malay Mail, March 29, 1964</i><br>", "<b><br>Others on LEE KUAN YEW:</b><br><br>Lee Kuan Yew’s political power has always been built over the dead bodies of his friends and allies.<i>– Malaysian Chinese Association, circa 1964</i><br>", "<b><br>Others on LEE KUAN YEW:</b><br><br>Harry, you’re the best bloody Englishman east of Suez.<i>– George Brown, Foreign Secretary of the United Kingdom (1966-68)</i><br>", "<b><br>Others on LEE KUAN YEW:</b><br><br>Kuan Yew, I can never trust you as a politician.<i>– Tunku Abdul Rahman, Prime Minister of Malaysia, in 1975</i><br>", "<b><br>Others on LEE KUAN YEW:</b><br><br>The fact that a leader of Lee’s breadth of vision was not able to act on a broader stage represents an incalculable loss to the world<i>-Richard Nixon, President of the United States</i><br><br>"};
    static int cnt = 0;
    static int impCnt = 0;
    static String shareStr = "";
    private static Menu mOptionsMenu;
    final Context context = this;
    boolean action_important;
    String tmp = "", tmp1 = "";
    Toolbar mToolbar;
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Collections.shuffle(Arrays.asList(Quotes));
        mSectionsPagerAdapter = new SectionsPagerAdapter(
                getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        setupEvenlyDistributedToolbar();

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                final SharedPreferences.Editor editor = sp.edit();
                if (item.toString().equalsIgnoreCase("Storage")) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            context);
                   // set title
                    alertDialogBuilder.setTitle("Favourites");
                    // set dialog message
                    String temp = "";
                    int tpi = 0;
                    int size = sp.getInt("Status_size", 0);
                    for (int i = 1; i < size + 1; i++) {
                        if (sp.getString("Quotes_" + i, null) != null) {
                            tpi = tpi + 1;
                            temp = temp + tpi + ")" + sp.getString("Quotes_" + i, null) + "\n" + "\t\t\t\t\t~~~~~~~~~~~~~~~" + "\n";
                        }
                    }

                    if (size != 0 & tpi != 0) {
                        alertDialogBuilder
                                .setMessage((temp).replace("<b>", "").replace("<br>", "").replace("</b>", "").replace("<br><br>", "").replace(":", ":\n"))
                                .setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                                .setNegativeButton("Clear All", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        callin();
                                    }
                                });
                    } else {
                        alertDialogBuilder
                                .setMessage("Please Click (*) Star Icon on your favourites Quotes to  make it in  favourites list.")
                                .setCancelable(false)
                                .setNegativeButton("ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                    }

                   // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    // show it
                    alertDialog.show();
                }
                if (item.toString().equalsIgnoreCase("Refresh")) {
                    Collections.shuffle(Arrays.asList(Quotes));
                    if (mViewPager.getCurrentItem() == 0)
                        mViewPager.setCurrentItem(3);
                    else
                        mViewPager.setCurrentItem(0);

                }

                if (item.toString().equalsIgnoreCase("Share")) {
                    TextView tv = (TextView) findViewById(R.id.section_label);

                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Lee Kuan Yew Quotes");
                    if (mViewPager.getCurrentItem() + 1 != Quotes.length)
                        if (Quotes[mViewPager.getCurrentItem() + 1].contains("<i>"))
                            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, (Quotes[mViewPager.getCurrentItem() + 1]).replace("<b>", "").replace("<br>", "").replace("</b>", "").replace("<br><br>", "").replace(":", ":\n").replace("<i>", "").replace("</i>", "") + "#LYKQuotes #LeeKuanYew (via) V Apps[Download the android app @ http://goo.gl/i1TDJP]");
                        else
                            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, (Quotes[mViewPager.getCurrentItem() + 1]).replace("<b>", "").replace("<br>", "").replace("</b>", "").replace("<br><br>", "").replace(":", ":\n") + " - Lee Kuan Yew. #LYKQuotes #LeeKuanYew (via) V Apps[Download the android app @ http://goo.gl/i1TDJP] ");
                    else if (Quotes[1].contains("<i>"))
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, (Quotes[1]).replace("<b>", "").replace("<br>", "").replace("</b>", "").replace("<br><br>", "").replace(":", ":\n").replace("<i>", "").replace("</i>", "") + " - #LYKQuotes #LeeKuanYew (via) V Apps [Download the android app @ http://goo.gl/i1TDJP]");
                    else
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, (Quotes[1]).replace("<b>", "").replace("<br>", "").replace("</b>", "").replace("<br><br>", "").replace(":", ":\n") + " - Lee Kuan Yew. #LYKQuotes #LeeKuanYew (via) V Apps[Download the android app @ http://goo.gl/i1TDJP]");
                    startActivity(Intent.createChooser(sharingIntent, "Share via"));
                }
                return true;
            }

        });
    }


    public void setupEvenlyDistributedToolbar() {
        // Use Display metrics to get Screen Dimensions
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        // Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        // Inflate your menu
        mToolbar.inflateMenu(R.menu.menu_main);
        // Add 10 spacing on either side of the toolbar
        mToolbar.setContentInsetsAbsolute(10, 10);
        // Get the ChildCount of your Toolbar, this should only be 1
        int childCount = mToolbar.getChildCount();
        // Get the Screen Width in pixels
        int screenWidth = metrics.widthPixels;
        // Create the Toolbar Params based on the screenWidth
        Toolbar.LayoutParams toolbarParams = new Toolbar.LayoutParams(screenWidth, LayoutParams.WRAP_CONTENT);
        // Loop through the child Items
        for (int i = 0; i < childCount; i++) {
            // Get the item at the current index
            View childView = mToolbar.getChildAt(i);
            // If its a ViewGroup
            if (childView instanceof ViewGroup) {
                // Set its layout params
                childView.setLayoutParams(toolbarParams);
                // Get the child count of this view group, and compute the item widths based on this count & screen size
                int innerChildCount = ((ViewGroup) childView).getChildCount();
                int itemWidth = (screenWidth / innerChildCount);
                // Create layout params for the ActionMenuView
                ActionMenuView.LayoutParams params = new ActionMenuView.LayoutParams(itemWidth, LayoutParams.WRAP_CONTENT);
                // Loop through the children
                for (int j = 0; j < innerChildCount; j++) {
                    View grandChild = ((ViewGroup) childView).getChildAt(j);
                    if (grandChild instanceof ActionMenuItemView) {
                        // set the layout parameters on each View
                        grandChild.setLayoutParams(params);
                    }
                }
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mOptionsMenu = menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main1, menu);
        if (action_important == true)
            action_important = false;
        int size = sp.getInt("Status_size", 0);
        cnt = size;
        for (int i = 1; i < size + 1; i++) {
            if (Quotes.length == mViewPager.getCurrentItem() + 1)
                tmp = Quotes[1];
            else
                tmp = Quotes[mViewPager.getCurrentItem() + 1];
            if ((tmp).equalsIgnoreCase(sp.getString("Quotes_" + i, null))) {
                menu.getItem(0).setIcon(R.drawable.ic_action_important);
                action_important = true;
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor editor = sp.edit();

        switch (item.getItemId()) {
            case R.id.action_important:
                action_important = !action_important;
                if (action_important) {
                    mOptionsMenu.findItem(R.id.action_important).setIcon(R.drawable.ic_action_important);
                    cnt = cnt + 1;
                    editor.putInt("Status_size", cnt);
                    if (Quotes.length == mViewPager.getCurrentItem() + 1)
                        tmp1 = Quotes[1];
                    else
                        tmp1 = Quotes[mViewPager.getCurrentItem() + 1];
                    editor.putString("Quotes_" + cnt, tmp1);
                    editor.apply();
                } else {
                    mOptionsMenu.findItem(R.id.action_important).setIcon(R.drawable.ic_action_not_important);
                    int size = sp.getInt("Status_size", 0);
                    if (Quotes.length == mViewPager.getCurrentItem() + 1)
                        tmp1 = Quotes[1];
                    else
                        tmp1 = Quotes[mViewPager.getCurrentItem() + 1];
                    for (int i = 1; i < size + 1; i++) {
                        if ((tmp1).equalsIgnoreCase(sp.getString("Quotes_" + i, null))) {
                            editor.remove("Quotes_" + i);
                            editor.apply();
                            cnt = cnt - 1;
                        }
                    }

                }
                return true;
            case R.id.action_about:

                View checkboxview = View.inflate(this, R.layout.checkbox, null);
                CheckBox ck = (CheckBox) checkboxview.findViewById(R.id.checkbox);
                ck.setText("Enable Intro Speech");
                if (sp.getString("checked", "nope").equalsIgnoreCase("true")) {
                    ck.setChecked(true);

                }

                ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                      if (isChecked) {
                                                          editor.putString("checked", "true");
                                                          editor.apply();

                                                      } else {
                                                          editor.putString("checked", "false");
                                                          editor.apply();
                                                      }
                                                  }
                                              }
                );
                AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(
                        context);
                // set title
                alertDialogBuilder1.setTitle("V Apps");
                // set dialog message
                alertDialogBuilder1
                        .setMessage("Version 1.9\nDeveloped by Vimal Thickvijayan for www.hadron.in\nCredits:GoodReads,Straitstimes and Wikiquotes\n")
                        .setView(checkboxview)
                        .setCancelable(false)
                        .setPositiveButton("Rate Us", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "in.hadron.leekuanyewquotes")));
                            }
                        })
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog1 = alertDialogBuilder1.create();
                alertDialog1.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void callin() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sp.edit();
        int size = sp.getInt("Status_size", 0);

        for (int i = 1; i < size + 1; i++) {
            editor.remove("Quotes_" + i);

        }
        cnt = 0;
        editor.putInt("Status_size", cnt);
        editor.apply();
        mOptionsMenu.findItem(R.id.action_important).setIcon(R.drawable.ic_action_not_important);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";
        TextView textView;
        View rootView;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);


            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            setHasOptionsMenu(true);

            rootView = inflater.inflate(R.layout.fragment_main, container,
                    false);
            textView = (TextView) rootView
                    .findViewById(R.id.section_label);

            textView.setText(Html.fromHtml(Quotes[(getArguments().getInt(ARG_SECTION_NUMBER))]));
            textView.setMovementMethod(new ScrollingMovementMethod());
            return rootView;
        }


    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {


            if (position == Quotes.length - 1)
                position = 0;
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {

            return Quotes.length;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }


}
