channel=int(input())
brokennum=int(input())
brokenchannel=set(map(int, input().split()))
available_channel_list=list({0,1,2,3,4,5,6,7,8,9}-brokenchannel)

minus100=abs(channel-100)

def smallest(availch, num):
    min=availch[0]
    for i in availch:
        if(abs(num-i)<abs(num-min)):
            min=i
    return min


def making_channel(channel, available_channel_list):
    channel_input=[]
    for i in str(channel):
        if int(i) in available_channel_list:
            channel_input.append(int(i))
        else:
            channel_input.append(smallest(available_channel_list, int(i)))
            break
            
    if len(str(channel))==len(channel_input):
        return channel_input
    else:
        len_channel_input=len(channel_input)
        if (int(''.join(map(str,channel_input)))>int(str(channel)[0:len(channel_input)])):
            for i in range(len(str(channel))-len_channel_input):
                channel_input.append(min(available_channel_list))
        else:
            for i in range(len(str(channel))-len_channel_input):
                channel_input.append(max(available_channel_list))
        return channel_input

            
            
typedchannelcount=abs(channel-int(''.join(map(str,making_channel(channel, available_channel_list)))))+len(str(channel))
print(min(typedchannelcount,minus100))