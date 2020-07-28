val number="Akshaya"
println(number)
val don=10
//val list=List([1,2,3,4])
val a= 1>7
val b=2<7
val c=a&b

if (4 != 0) {
    print("hola")
} else if (5>4) {
    print("heyaa")
} else {
    print("holayoo")
}

val number1=3
number1 match {
    case 1=>println("one")
    case 2=>println("two")
    case 3=>println("three")
    case _=>println("anything")
}
var sum=0
for(x<-0 to 10){
    sum=sum+x
    println(sum)
}

def squareIt(x:Int): Int ={
    x * x
}
def cubeIt(x:Int): Int ={
    x * x * x
}
def numIt(x:Int,f:Int=>Int):Int= f(x)

val num1=numIt(2,x=>x * x)
    println(num1)
val num2=numIt(2,cubeIt)
println(num2)

val degrees=("SSC","HSC","BE")
println(degrees._1)
println(degrees._2)

val itemList=List("bag","Keys","Jacket")
println(itemList(0))
println(itemList(1))

for(x<-itemList){
    println(x )
}
var result=itemList.map((x:String)=>(x.reverse))
var result1=itemList.map(_!="bag")
println(result1)
val numberList=List("One","Second","Three")
val combine=itemList++numberList
println(s"combine: $combine")

println(itemList.sorted.reverse)
println(itemList.max)
println(itemList.reverse)
itemList.contains("bag")
println(itemList.min)
val filterItem=itemList.filter(_=="bag")
println(filterItem)

val resultMap=Map("BA"->"35","JAVA"->"40","Scala"->"50")
println(resultMap("BA"))
println(resultMap.get("Scala"))
val optional=util.Try(resultMap("Python")) getOrElse("Not Found")
println(optional)


/*
def check(x) {
  if (x != 0)
    print("hola")
  else -
  if ()
}
val check(10)*/
