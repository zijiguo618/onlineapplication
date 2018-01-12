INPUT='/Users/zijiguo/Documents/Archive/'
cd $INPUT
files=$(ls)
echo "Date,All amount, Currency">> "/Users/zijiguo/Desktop/test.txt"
for INPUT1 in $files; do
	cd $INPUT$INPUT1
	filenames=$(find -L . -name '*[0-9]')
	for i in $filenames; do
		lines=$(sed -n '5,17p' $i)
		currency=$(echo $i | grep -o -E '[0-9]+' | tail -1)
		date=$(echo $lines | grep -o -E '[0-9]+' | head -1)
		number=$(echo $lines | grep -o -E '[0-9]+\.[0-9]+' | tail -1)
		echo $date,$number,$currency>>"/Users/zijiguo/Desktop/test.txt"
	done
done
